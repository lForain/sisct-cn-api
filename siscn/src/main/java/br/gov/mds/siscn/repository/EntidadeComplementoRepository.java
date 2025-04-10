package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.EntidadeComplemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "entidades-complemento", collectionResourceRel = "entidadesComplemento", itemResourceRel = "entidadeComplemento")
public interface EntidadeComplementoRepository extends JpaRepository<EntidadeComplemento, Integer> {
    
    /**
     * Finds complementary information by cadastro nacional ID
     * 
     * @param id ID of the cadastro nacional
     * @return Optional containing the complementary information if found
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    Optional<EntidadeComplemento> findById(Integer id);
    
    /**
     * Finds all complementary information for entities that have 12-step programs
     * 
     * @param tipoDozePassos Type indicator for 12-step programs ("S" for yes)
     * @return List of complementary information for entities with 12-step programs
     */
    @RestResource(path = "por-doze-passos", rel = "por-doze-passos")
    List<EntidadeComplemento> findByTipoDozePassos(String tipoDozePassos);
    
    /**
     * Finds all complementary information for entities that have psychosocial care
     * 
     * @param tipoAtendimentoPsicosocial Type indicator for psychosocial care ("S" for yes)
     * @return List of complementary information for entities with psychosocial care
     */
    @RestResource(path = "por-atendimento-psicosocial", rel = "por-atendimento-psicosocial")
    List<EntidadeComplemento> findByTipoAtendimentoPsicosocial(String tipoAtendimentoPsicosocial);
    
    /**
     * Finds all complementary information for entities that have partnerships
     * 
     * @param tipoPossuiParcerias Type indicator for partnerships ("S" for yes)
     * @return List of complementary information for entities with partnerships
     */
    @RestResource(path = "por-possui-parcerias", rel = "por-possui-parcerias")
    List<EntidadeComplemento> findByTipoPossuiParcerias(String tipoPossuiParcerias);
}
