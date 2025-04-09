package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Diligencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
@RepositoryRestResource(path = "diligencias", collectionResourceRel = "diligencias", itemResourceRel = "diligencia")
public interface DiligenciaRepository extends JpaRepository<Diligencia, Integer> {
    
    /**
     * Finds all active diligences by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param diligenciaAtivo Active status ("S" for active)
     * @return List of active diligences
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<Diligencia> findByCadastroNacionalIdAndDiligenciaAtivo(Integer cadastroNacionalId, String diligenciaAtivo);
    
    /**
     * Finds all diligences by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of diligences
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<Diligencia> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all diligences by start date
     * 
     * @param dataInicioDiligencia Start date of the diligence
     * @return List of diligences
     */
    @RestResource(path = "por-data-inicio", rel = "por-data-inicio")
    List<Diligencia> findByDataInicioDiligencia(Date dataInicioDiligencia);
    
    /**
     * Finds all diligences by send date
     * 
     * @param dataEnvio Send date of the diligence
     * @return List of diligences
     */
    @RestResource(path = "por-data-envio", rel = "por-data-envio")
    List<Diligencia> findByDataEnvio(Date dataEnvio);
}
