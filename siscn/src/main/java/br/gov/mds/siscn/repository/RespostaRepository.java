package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "respostas", collectionResourceRel = "respostas", itemResourceRel = "resposta")
public interface RespostaRepository extends JpaRepository<Resposta, Integer> {
    
    /**
     * Finds all active answers
     * 
     * @param respostaAtivo Active status ("S" for active)
     * @return List of active answers
     */
    @RestResource(path = "ativas", rel = "ativas")
    List<Resposta> findByRespostaAtivo(String respostaAtivo);
    
    /**
     * Finds all answers by question ID
     * 
     * @param perguntaId ID of the question
     * @return List of answers for the specified question
     */
    @RestResource(path = "por-pergunta", rel = "por-pergunta")
    List<Resposta> findByPerguntaId(Integer perguntaId);
    
    /**
     * Finds all active answers by question ID
     * 
     * @param perguntaId ID of the question
     * @param respostaAtivo Active status ("S" for active)
     * @return List of active answers for the specified question
     */
    @RestResource(path = "por-pergunta-ativo", rel = "por-pergunta-ativo")
    List<Resposta> findByPerguntaIdAndRespostaAtivo(Integer perguntaId, String respostaAtivo);
    
    /**
     * Finds all answers containing the search term in the name
     * 
     * @param nome Part of the answer name to search for
     * @return List of matching answers
     */
    @RestResource(path = "por-nome", rel = "por-nome")
    List<Resposta> findByNomeContainingIgnoreCase(String nome);
}
