package br.gov.mds.siscn.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.siscn.entity.CadastroNacional;
import br.gov.mds.siscn.repository.CadastroNacionalRepository;

@Service
public class CadastroNacionalService {

    List<String> camposNulos = new ArrayList<>();

    @Autowired
    private CadastroNacionalRepository repository;

    public List<String> validaCadastro(String cnpj) {
        camposNulos = new ArrayList<>();

        // Usando a opção com Optional
        Optional<CadastroNacional> cadastroOpt = repository.findOneByCnpj(cnpj);

        if (cadastroOpt.isEmpty()) {
            camposNulos.add("Cadastro não encontrado para o CNPJ: " + cnpj);
            return camposNulos;
        }

        CadastroNacional cadastro = cadastroOpt.get();
        // Replace Funcionario.class with CadastroNacional.class if Funcionario is not
        // defined
        System.err.println("Cadastro encontrado: " + EntityLabelUtils.getLabel(CadastroNacional.class, "id"));
        // Validações dos campos
        if (cadastro.getRazaoSocial() == null || cadastro.getRazaoSocial().isBlank()) {
            fillCamposNulos("razaoSocial");
        }

        if (cadastro.getNumeroFiliais() == null) {
            fillCamposNulos("numeroFiliais");
        }

        if (cadastro.getPrazoProjeto() == null) {
            fillCamposNulos("prazoProjeto");
        }

        return camposNulos;
    }

    void fillCamposNulos(String campo) {
        camposNulos.add(EntityLabelUtils.getLabel(CadastroNacional.class, campo).trim()
                + " precisa ser informado(a).");
    }

    public class EntityLabelUtils {
        public static String getLabel(Class<?> entityClass, String fieldName) {
            try {
                Field field = entityClass.getDeclaredField(fieldName);

                // Verifica anotação customizada primeiro
                if (field.isAnnotationPresent(FieldMetadata.class)) {
                    return field.getAnnotation(FieldMetadata.class).label();
                }

                // Fallback para o nome do campo
                return field.getName();
            } catch (NoSuchFieldException e) {
                return fieldName;
            }
        }
    }
}