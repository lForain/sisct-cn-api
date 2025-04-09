package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.CadastroNacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "cadastros-nacionais", collectionResourceRel = "cadastrosNacionais", itemResourceRel = "cadastroNacional")
public interface CadastroNacionalRepository extends JpaRepository<CadastroNacional, Integer> {
    
    /**
     * Finds a cadastro nacional by CNPJ
     * 
     * @param cnpj CNPJ of the entity
     * @return Optional containing the cadastro nacional if found
     */
    @RestResource(path = "por-cnpj", rel = "por-cnpj")
    Optional<CadastroNacional> findByCnpj(String cnpj);
    
    /**
     * Finds all active cadastros nacionais
     * 
     * @param cadastroNacionalAtivo Active status ("S" for active)
     * @return List of active cadastros nacionais
     */
    @RestResource(path = "ativos", rel = "ativos")
    List<CadastroNacional> findByCadastroNacionalAtivo(String cadastroNacionalAtivo);
    
    /**
     * Finds all cadastros nacionais by status
     * 
     * @param status Status code
     * @return List of cadastros nacionais with the specified status
     */
    @RestResource(path = "por-status", rel = "por-status")
    List<CadastroNacional> findByStatus(Integer status);
    
    /**
     * Finds all cadastros nacionais that have CEBAS
     * 
     * @param possuiCebas CEBAS status ("S" for yes)
     * @return List of cadastros nacionais with CEBAS
     */
    @RestResource(path = "com-cebas", rel = "com-cebas")
    List<CadastroNacional> findByPossuiCebas(String possuiCebas);
    
    /**
     * Finds all cadastros nacionais by razão social containing the search term
     * 
     * @param razaoSocial Part of the razão social to search for
     * @return List of matching cadastros nacionais
     */
    @RestResource(path = "por-razao-social", rel = "por-razao-social")
    List<CadastroNacional> findByRazaoSocialContainingIgnoreCase(String razaoSocial);
    
    /**
     * Finds all cadastros nacionais by nome fantasia containing the search term
     * 
     * @param nomeFantasia Part of the nome fantasia to search for
     * @return List of matching cadastros nacionais
     */
    @RestResource(path = "por-nome-fantasia", rel = "por-nome-fantasia")
    List<CadastroNacional> findByNomeFantasiaContainingIgnoreCase(String nomeFantasia);
}
