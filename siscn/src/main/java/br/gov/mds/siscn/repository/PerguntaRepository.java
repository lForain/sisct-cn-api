package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "perguntas", collectionResourceRel = "perguntas", itemResourceRel = "pergunta")
public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
    
    /**
     * Finds all active questions
     * 
     * @param perguntaAtivo Active status ("S" for active)
     * @return List of active questions
     */
    @RestResource(path = "ativas", rel = "ativas")
    List<Pergunta> findByPerguntaAtivo(String perguntaAtivo);
    
    /**
     * Finds all questions by display type
     * 
     * @param tipoExibirPergunta Display type
     * @return List of questions with the specified display type
     */
    @RestResource(path = "por-tipo-exibicao", rel = "por-tipo-exibicao")
    List<Pergunta> findByTipoExibirPergunta(String tipoExibirPergunta);
    
    /**
     * Finds all questions by direction code
     * 
     * @param codigoDirecao Direction code
     * @return List of questions with the specified direction code
     */
    @RestResource(path = "por-direcao", rel = "por-direcao")
    List<Pergunta> findByCodigoDirecao(Integer codigoDirecao);
    
    /**
     * Finds all questions containing the search term in the name
     * 
     * @param nomePergunta Part of the question name to search for
     * @return List of matching questions
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<Pergunta> findByNomePerguntaContainingIgnoreCase(String nomePergunta);
}
