package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "contatos", collectionResourceRel = "contatos", itemResourceRel = "contato")
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    
    /**
     * Finds all active contacts by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param contatoAtivo Active status ("S" for active)
     * @return List of active contacts
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<Contato> findByCadastroNacionalIdAndContatoAtivo(Integer cadastroNacionalId, String contatoAtivo);
    
    /**
     * Finds all contacts by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of contacts
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<Contato> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all contacts by type
     * 
     * @param tipoContatoId Type of contact ID
     * @return List of contacts
     */
    @RestResource(path = "por-tipo", rel = "por-tipo")
    List<Contato> findByTipoContatoId(Integer tipoContatoId);
}
