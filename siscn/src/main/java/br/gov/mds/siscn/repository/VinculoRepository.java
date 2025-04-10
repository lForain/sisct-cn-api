package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Vinculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "vinculos", collectionResourceRel = "vinculos", itemResourceRel = "vinculo")
public interface VinculoRepository extends JpaRepository<Vinculo, Integer> {
    
    /**
     * Finds all active relationship types
     * 
     * @param vinculoAtivo Active status ("S" for active)
     * @return List of active relationship types
     */
    @RestResource(path = "ativos", rel = "ativos")
    List<Vinculo> findByVinculoAtivo(String vinculoAtivo);
    
    /**
     * Finds all relationship types by name containing the search term
     * 
     * @param nomeVinculo Part of the relationship type name to search for
     * @return List of matching relationship types
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<Vinculo> findByNomeVinculoContainingIgnoreCase(String nomeVinculo);
}
