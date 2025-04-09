package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.RespostaSelecionada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "respostas-selecionadas", collectionResourceRel = "respostasSelecionadas", itemResourceRel = "respostaSelecionada")
public interface RespostaSelecionadaRepository extends JpaRepository<RespostaSelecionada, Integer> {
    
    /**
     * Finds all active selected responses by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param respostaSelecionadaAtivo Active status ("S" for active)
     * @return List of active selected responses
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<RespostaSelecionada> findByCadastroNacionalIdAndRespostaSelecionadaAtivo(Integer cadastroNacionalId, String respostaSelecionadaAtivo);
    
    /**
     * Finds all selected responses by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of selected responses
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<RespostaSelecionada> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all selected responses by response ID
     * 
     * @param resposta ID of the response
     * @return List of selected responses
     */
    @RestResource(path = "por-resposta", rel = "por-resposta")
    List<RespostaSelecionada> findByResposta(Integer resposta);
    
    /**
     * Finds a specific selected response by cadastro nacional ID and response ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param resposta ID of the response
     * @return The selected response if it exists
     */
    @RestResource(path = "por-cadastro-resposta", rel = "por-cadastro-resposta")
    RespostaSelecionada findByCadastroNacionalIdAndResposta(Integer cadastroNacionalId, Integer resposta);
}
