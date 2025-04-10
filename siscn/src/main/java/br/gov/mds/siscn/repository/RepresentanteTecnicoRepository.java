package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.RepresentanteTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "representantes-tecnicos", collectionResourceRel = "representantesTecnicos", itemResourceRel = "representanteTecnico")
public interface RepresentanteTecnicoRepository extends JpaRepository<RepresentanteTecnico, Integer> {
    
    /**
     * Finds all active technical representatives by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param representanteTecnicoAtivo Active status ("S" for active)
     * @return List of active technical representatives
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<RepresentanteTecnico> findByCadastroNacionalIdAndRepresentanteTecnicoAtivo(Integer cadastroNacionalId, String representanteTecnicoAtivo);
    
    /**
     * Finds all technical representatives by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of technical representatives
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<RepresentanteTecnico> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds a technical representative by CPF
     * 
     * @param cpf CPF of the technical representative
     * @return Optional containing the technical representative if found
     */
    @RestResource(path = "por-cpf", rel = "por-cpf")
    Optional<RepresentanteTecnico> findByCpf(String cpf);
    
    /**
     * Finds all technical representatives by name containing the search term
     * 
     * @param nome Part of the name to search for
     * @return List of matching technical representatives
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<RepresentanteTecnico> findByNomeContainingIgnoreCase(String nome);
    
    /**
     * Finds all technical representatives by email containing the search term
     * 
     * @param email Part of the email to search for
     * @return List of matching technical representatives
     */
    @RestResource(path = "por-email", rel = "por-email")
    List<RepresentanteTecnico> findByEmailContainingIgnoreCase(String email);
    
    /**
     * Finds all technical representatives with experience
     * 
     * @param tipoPossuiExperiencia Type indicator for experience ("S" for yes)
     * @return List of technical representatives with experience
     */
    @RestResource(path = "por-experiencia", rel = "por-experiencia")
    List<RepresentanteTecnico> findByTipoPossuiExperiencia(String tipoPossuiExperiencia);
    
    /**
     * Finds all technical representatives by course name containing the search term
     * 
     * @param nomeCurso Part of the course name to search for
     * @return List of matching technical representatives
     */
    @RestResource(path = "por-curso", rel = "por-curso")
    List<RepresentanteTecnico> findByNomeCursoContainingIgnoreCase(String nomeCurso);
}
