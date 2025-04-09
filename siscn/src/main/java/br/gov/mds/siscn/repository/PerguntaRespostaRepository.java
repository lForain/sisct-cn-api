package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.PerguntaResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRespostaRepository extends JpaRepository<PerguntaResposta, Long> {

    @Query(value = "SELECT * FROM SISCT.VW_PERGUNTAS_RESPOSTAS WHERE PK_PERGUNTAS = :pkPerguntas", nativeQuery = true)
    List<PerguntaResposta> findByPkPerguntas(@Param("pkPerguntas") Long pkPerguntas);

    @Query(value = "SELECT * FROM SISCT.VW_PERGUNTAS_RESPOSTAS", nativeQuery = true)
    List<PerguntaResposta> findAllFromView();
}