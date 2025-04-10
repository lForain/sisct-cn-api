package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.EstruturaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "estruturas-fisicas", collectionResourceRel = "estruturasFisicas", itemResourceRel = "estruturaFisica")
public interface EstruturaFisicaRepository extends JpaRepository<EstruturaFisica, Integer> {
    
    /**
     * Finds physical structure information by cadastro nacional ID
     * 
     * @param id ID of the cadastro nacional
     * @return Optional containing the physical structure information if found
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    Optional<EstruturaFisica> findById(Integer id);
    
    /**
     * Finds all physical structures with entity space
     * 
     * @param tipoEspacoEntidade Type indicator for entity space ("S" for yes)
     * @return List of physical structures with entity space
     */
    @RestResource(path = "por-espaco-entidade", rel = "por-espaco-entidade")
    List<EstruturaFisica> findByTipoEspacoEntidade(String tipoEspacoEntidade);
    
    /**
     * Finds all physical structures with family space
     * 
     * @param tipoEspacoFamilia Type indicator for family space ("S" for yes)
     * @return List of physical structures with family space
     */
    @RestResource(path = "por-espaco-familia", rel = "por-espaco-familia")
    List<EstruturaFisica> findByTipoEspacoFamilia(String tipoEspacoFamilia);
    
    /**
     * Finds all physical structures with individual space
     * 
     * @param tipoEspacoIndividual Type indicator for individual space ("S" for yes)
     * @return List of physical structures with individual space
     */
    @RestResource(path = "por-espaco-individual", rel = "por-espaco-individual")
    List<EstruturaFisica> findByTipoEspacoIndividual(String tipoEspacoIndividual);
}
