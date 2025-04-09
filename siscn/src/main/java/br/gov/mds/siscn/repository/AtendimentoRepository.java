package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "atendimentos", collectionResourceRel = "atendimentos", itemResourceRel = "atendimento")
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
    
    /**
     * Finds all active service attendances by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param atendimentoAtivo Active status ("S" for active)
     * @return List of active attendances
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<Atendimento> findByCadastroNacionalIdAndAtendimentoAtivo(Integer cadastroNacionalId, String atendimentoAtivo);
    
    /**
     * Finds all attendances by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of attendances
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<Atendimento> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all attendances by type
     * 
     * @param tipoAtendimento Type of attendance
     * @return List of attendances
     */
    @RestResource(path = "por-tipo", rel = "por-tipo")
    List<Atendimento> findByTipoAtendimento(Integer tipoAtendimento);
}
