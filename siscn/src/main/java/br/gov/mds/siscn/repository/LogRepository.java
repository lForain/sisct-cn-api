package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "logs", collectionResourceRel = "logs", itemResourceRel = "log")
public interface LogRepository extends JpaRepository<Log, Integer> {
    
    /**
     * Finds all logs by date
     * 
     * @param data Date of the logs
     * @return List of logs created on the specified date
     */
    @RestResource(path = "por-data", rel = "por-data")
    List<Log> findByData(Date data);
    
    /**
     * Finds all logs by user name
     * 
     * @param nomeUsuario Name of the user
     * @return List of logs created by the specified user
     */
    @RestResource(path = "por-usuario", rel = "por-usuario")
    List<Log> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
    
    /**
     * Finds all logs by module name
     * 
     * @param nomeModulo Name of the module
     * @return List of logs from the specified module
     */
    @RestResource(path = "por-modulo", rel = "por-modulo")
    List<Log> findByNomeModuloContainingIgnoreCase(String nomeModulo);
    
    /**
     * Finds all logs by description containing the search term
     * 
     * @param descricao Part of the description to search for
     * @return List of matching logs
     */
    @RestResource(path = "por-descricao", rel = "por-descricao")
    List<Log> findByDescricaoContainingIgnoreCase(String descricao);
}
