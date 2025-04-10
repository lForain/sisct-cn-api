package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.TipoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "tipos-atendimento", collectionResourceRel = "tiposAtendimento", itemResourceRel = "tipoAtendimento")
public interface TipoAtendimentoRepository extends JpaRepository<TipoAtendimento, Integer> {
    
    /**
     * Finds all active attendance types
     * 
     * @param tipoAtendimentoAtivo Active status ("S" for active)
     * @return List of active attendance types
     */
    @RestResource(path = "ativos", rel = "ativos")
    List<TipoAtendimento> findByTipoAtendimentoAtivo(String tipoAtendimentoAtivo);
    
    /**
     * Finds all attendance types by name containing the search term
     * 
     * @param nome Part of the name to search for
     * @return List of matching attendance types
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<TipoAtendimento> findByNomeContainingIgnoreCase(String nome);
    
    /**
     * Finds all attendance types by group number
     * 
     * @param numeroGrupo Group number
     * @return List of attendance types in the specified group
     */
    @RestResource(path = "por-grupo", rel = "por-grupo")
    List<TipoAtendimento> findByNumeroGrupo(Integer numeroGrupo);
    
    /**
     * Finds all active attendance types by group number
     * 
     * @param numeroGrupo Group number
     * @param tipoAtendimentoAtivo Active status ("S" for active)
     * @return List of active attendance types in the specified group
     */
    @RestResource(path = "por-grupo-ativo", rel = "por-grupo-ativo")
    List<TipoAtendimento> findByNumeroGrupoAndTipoAtendimentoAtivo(Integer numeroGrupo, String tipoAtendimentoAtivo);
}
