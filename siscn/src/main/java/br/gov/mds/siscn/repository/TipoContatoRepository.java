package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "tipos-contato", collectionResourceRel = "tiposContato", itemResourceRel = "tipoContato")
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer> {
    
    /**
     * Finds all active contact types
     * 
     * @param tipoContatoAtivo Active status ("S" for active)
     * @return List of active contact types
     */
    @RestResource(path = "ativos", rel = "ativos")
    List<TipoContato> findByTipoContatoAtivo(String tipoContatoAtivo);
    
    /**
     * Finds all contact types by name containing the search term
     * 
     * @param nomeTipoContato Part of the contact type name to search for
     * @return List of matching contact types
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<TipoContato> findByNomeTipoContatoContainingIgnoreCase(String nomeTipoContato);
}
