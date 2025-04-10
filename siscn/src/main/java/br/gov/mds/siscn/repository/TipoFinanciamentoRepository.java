package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.TipoFinanciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "tipos-financiamento", collectionResourceRel = "tiposFinanciamento", itemResourceRel = "tipoFinanciamento")
public interface TipoFinanciamentoRepository extends JpaRepository<TipoFinanciamento, Integer> {
    
    /**
     * Finds all active financing types
     * 
     * @param tipoFinanciamentoAtivo Active status ("S" for active)
     * @return List of active financing types
     */
    @RestResource(path = "ativos", rel = "ativos")
    List<TipoFinanciamento> findByTipoFinanciamentoAtivo(String tipoFinanciamentoAtivo);
    
    /**
     * Finds all financing types by name containing the search term
     * 
     * @param nome Part of the name to search for
     * @return List of matching financing types
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<TipoFinanciamento> findByNomeContainingIgnoreCase(String nome);
    
    /**
     * Finds all financing types by group number
     * 
     * @param numeroGrupo Group number
     * @return List of financing types in the specified group
     */
    @RestResource(path = "por-grupo", rel = "por-grupo")
    List<TipoFinanciamento> findByNumeroGrupo(Integer numeroGrupo);
    
    /**
     * Finds all active financing types by group number
     * 
     * @param numeroGrupo Group number
     * @param tipoFinanciamentoAtivo Active status ("S" for active)
     * @return List of active financing types in the specified group
     */
    @RestResource(path = "por-grupo-ativo", rel = "por-grupo-ativo")
    List<TipoFinanciamento> findByNumeroGrupoAndTipoFinanciamentoAtivo(Integer numeroGrupo, String tipoFinanciamentoAtivo);
}
