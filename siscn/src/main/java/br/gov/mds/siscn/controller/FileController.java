package br.gov.mds.siscn.controller;

import br.gov.mds.siscn.entity.Arquivo;
import br.gov.mds.siscn.entity.CadastroNacional;
import br.gov.mds.siscn.repository.CadastroNacionalRepository;
import br.gov.mds.siscn.service.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileStorageService fileStorageService;
    private final CadastroNacionalRepository cadastroNacionalRepository;


    public FileController(FileStorageService fileStorageService, 
                         CadastroNacionalRepository cadastroNacionalRepository) {
        this.fileStorageService = fileStorageService;
        this.cadastroNacionalRepository = cadastroNacionalRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("tipoArquivoId") Integer tipoArquivoId,
            @RequestParam("cadastroNacionalId") Integer cadastroNacionalId,
            @RequestParam(value = "complemento", required = false) String complemento,
            @RequestParam(value = "diasValidade", required = false) Integer diasValidade) {
        
        CadastroNacional cadastroNacional = cadastroNacionalRepository.findById(cadastroNacionalId)
                .orElseThrow(() -> new RuntimeException("CadastroNacional not found with id " + cadastroNacionalId));
        
        Arquivo arquivo = fileStorageService.storeFile(file, tipoArquivoId, cadastroNacional, complemento, diasValidade);
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/download/")
                .path(arquivo.getId().toString())
                .toUriString();
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", arquivo.getId());
        response.put("fileName", file.getOriginalFilename());
        response.put("fileType", file.getContentType());
        response.put("size", file.getSize());
        response.put("downloadUri", fileDownloadUri);
        response.put("tipoArquivo", arquivo.getTipoArquivo());
        response.put("cadastroNacionalId", cadastroNacionalId);
        response.put("dataValidade", arquivo.getDataValidade());
        
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/download/{arquivoId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer arquivoId, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(arquivoId);
        
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            // Log this in a real application
        }
        
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    @DeleteMapping("/{arquivoId}")
    public ResponseEntity<Map<String, Boolean>> deleteFile(@PathVariable Integer arquivoId) {
        boolean deleted = fileStorageService.deleteFile(arquivoId);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        
        return ResponseEntity.ok(response);
    }
}
