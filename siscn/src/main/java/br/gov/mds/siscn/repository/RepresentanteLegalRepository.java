package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.RepresentanteLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "representantes-legais", collectionResourceRel = "representantesLegais", itemResourceRel = "representanteLegal")
public interface RepresentanteLegalRepository extends JpaRepository<RepresentanteLegal, Integer> {
    
    /**
     * Finds all active legal representatives by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param representanteLegalAtivo Active status ("S" for active)
     * @return List of active legal representatives
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<RepresentanteLegal> findByCadastroNacionalIdAndRepresentanteLegalAtivo(Integer cadastroNacionalId, String representanteLegalAtivo);
    
    /**
     * Finds all legal representatives by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of legal representatives
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<RepresentanteLegal> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds a legal representative by CPF
     * 
     * @param cpf CPF of the legal representative
     * @return Optional containing the legal representative if found
     */
    @RestResource(path = "por-cpf", rel = "por-cpf")
    Optional<RepresentanteLegal> findByCpf(String cpf);
    
    /**
     * Finds all legal representatives by name containing the search term
     * 
     * @param nome Part of the name to search for
     * @return List of matching legal representatives
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<RepresentanteLegal> findByNomeContainingIgnoreCase(String nome);
    
    /**
     * Finds all legal representatives by email containing the search term
     * 
     * @param email Part of the email to search for
     * @return List of matching legal representatives
     */
    @RestResource(path = "por-email", rel = "por-email")
    List<RepresentanteLegal> findByEmailContainingIgnoreCase(String email);
    
    /**
     * Finds all legal representatives with mandate end date before the specified date
     * 
     * @param dataTerminoMandato End date threshold
     * @return List of legal representatives whose mandate ends before the specified date
     */
    @RestResource(path = "por-termino-mandato", rel = "por-termino-mandato")
    List<RepresentanteLegal> findByDataTerminoMandatoBefore(Date dataTerminoMandato);
}
