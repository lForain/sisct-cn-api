package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "profissoes", collectionResourceRel = "profissoes", itemResourceRel = "profissao")
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
    
    /**
     * Finds all active professions
     * 
     * @param profissaoAtivo Active status ("S" for active)
     * @return List of active professions
     */
    @RestResource(path = "ativas", rel = "ativas")
    List<Profissao> findByProfissaoAtivo(String profissaoAtivo);
    
    /**
     * Finds all professions by name containing the search term
     * 
     * @param nomeProfissao Part of the profession name to search for
     * @return List of matching professions
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<Profissao> findByNomeProfissaoContainingIgnoreCase(String nomeProfissao);
}
