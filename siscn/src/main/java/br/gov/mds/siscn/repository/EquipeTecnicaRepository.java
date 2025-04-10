package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.EquipeTecnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "equipe-tecnica", collectionResourceRel = "equipeTecnica", itemResourceRel = "equipeTecnica")
public interface EquipeTecnicaRepository extends JpaRepository<EquipeTecnica, Integer> {
    
    /**
     * Finds all active technical team members by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param equipeTecnicaAtivo Active status ("S" for active)
     * @return List of active technical team members
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<EquipeTecnica> findByCadastroNacionalIdAndEquipeTecnicaAtivo(Integer cadastroNacionalId, String equipeTecnicaAtivo);
    
    /**
     * Finds all technical team members by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of technical team members
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<EquipeTecnica> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all technical team members by profession
     * 
     * @param profissaoId ID of the profession
     * @return List of technical team members
     */
    @RestResource(path = "por-profissao", rel = "por-profissao")
    List<EquipeTecnica> findByProfissaoId(Integer profissaoId);
    
    /**
     * Finds all technical team members by employment type
     * 
     * @param vinculoId ID of the employment type
     * @return List of technical team members
     */
    @RestResource(path = "por-vinculo", rel = "por-vinculo")
    List<EquipeTecnica> findByVinculoId(Integer vinculoId);
}
