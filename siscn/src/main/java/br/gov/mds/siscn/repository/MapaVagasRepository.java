package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.MapaVagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "mapa-vagas", collectionResourceRel = "mapaVagas", itemResourceRel = "mapaVagas")
public interface MapaVagasRepository extends JpaRepository<MapaVagas, Integer> {
    
    /**
     * Finds all active vacancy maps by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param mapaVagasAtivo Active status ("S" for active)
     * @return List of active vacancy maps
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<MapaVagas> findByCadastroNacionalIdAndMapaVagasAtivo(Integer cadastroNacionalId, String mapaVagasAtivo);
    
    /**
     * Finds all vacancy maps by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of vacancy maps
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<MapaVagas> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all vacancy maps by financing type
     * 
     * @param tipoFinanciamento ID of the financing type
     * @return List of vacancy maps
     */
    @RestResource(path = "por-financiamento", rel = "por-financiamento")
    List<MapaVagas> findByTipoFinanciamento(Integer tipoFinanciamento);
}
