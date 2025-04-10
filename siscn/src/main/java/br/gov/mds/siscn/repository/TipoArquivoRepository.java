package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.TipoArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "tipos-arquivo", collectionResourceRel = "tiposArquivo", itemResourceRel = "tipoArquivo")
public interface TipoArquivoRepository extends JpaRepository<TipoArquivo, Integer> {
    
    /**
     * Finds all active file types
     * 
     * @param tipoArquivoAtivo Active status ("S" for active)
     * @return List of active file types
     */
    @RestResource(path = "ativos", rel = "ativos")
    List<TipoArquivo> findByTipoArquivoAtivo(String tipoArquivoAtivo);
    
    /**
     * Finds all file types by name containing the search term
     * 
     * @param nomeTipoArquivo Part of the file type name to search for
     * @return List of matching file types
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<TipoArquivo> findByNomeTipoArquivoContainingIgnoreCase(String nomeTipoArquivo);
}
