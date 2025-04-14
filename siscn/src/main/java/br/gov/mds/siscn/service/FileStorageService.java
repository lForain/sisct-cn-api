package br.gov.mds.siscn.service;

import br.gov.mds.siscn.entity.Arquivo;
import br.gov.mds.siscn.entity.CadastroNacional;
import br.gov.mds.siscn.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    private final ArquivoRepository arquivoRepository;

    public FileStorageService(
            @Value("${app.file-storage.location}") String fileStorageLocation,
            ArquivoRepository arquivoRepository) {
        this.fileStorageLocation = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        this.arquivoRepository = arquivoRepository;

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public Arquivo storeFile(MultipartFile file, Integer tipoArquivoId, CadastroNacional cadastroNacional, 
                             String complemento, Integer diasValidade) {
        try {
            // Normalize file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            
            if (fileName.contains("..")) {
                throw new RuntimeException("Filename contains invalid path sequence " + fileName);
            }

            // Generate unique filename to prevent collisions
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
            
            // Create directory for cadastroNacional if it doesn't exist
            Path cadastroDir = this.fileStorageLocation.resolve(cadastroNacional.getId().toString());
            if (!Files.exists(cadastroDir)) {
                Files.createDirectories(cadastroDir);
            }
            
            // Copy file to the target location
            Path targetLocation = cadastroDir.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Create and save arquivo record
            Arquivo arquivo = new Arquivo();
            arquivo.setArquivoUrl(targetLocation.toString());
            arquivo.setComplemento(complemento != null ? complemento : "");
            arquivo.setCadastroNacional(cadastroNacional);
            arquivo.setTipoArquivo(tipoArquivoId);
            arquivo.setArquivoAtivo("S");
            arquivo.setDataAtualizacao(LocalDateTime.now());
            
            if (diasValidade != null && diasValidade > 0) {
                arquivo.setDiasValidade(diasValidade);
                arquivo.setDataValidade(LocalDate.now().plusDays(diasValidade));
            }

            return arquivoRepository.save(arquivo);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file. Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(Integer arquivoId) {
        try {
            Arquivo arquivo = arquivoRepository.findById(arquivoId)
                    .orElseThrow(() -> new RuntimeException("File not found with id " + arquivoId));
            
            Path filePath = Paths.get(arquivo.getArquivoUrl());
            Resource resource = new UrlResource(filePath.toUri());
            
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + arquivo.getArquivoUrl());
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found", ex);
        }
    }
    
    public boolean deleteFile(Integer arquivoId) {
        try {
            Arquivo arquivo = arquivoRepository.findById(arquivoId)
                    .orElseThrow(() -> new RuntimeException("File not found with id " + arquivoId));
            
            Path filePath = Paths.get(arquivo.getArquivoUrl());
            
            // Delete the file if it exists
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            
            // Mark arquivo as inactive
            arquivo.setArquivoAtivo("N");
            arquivo.setDataAtualizacao(LocalDateTime.now());
            arquivoRepository.save(arquivo);
            
            return true;
        } catch (IOException ex) {
            throw new RuntimeException("Could not delete file", ex);
        }
    }
}
