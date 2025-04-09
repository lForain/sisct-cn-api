package br.gov.mds.siscn.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "VW_PERGUNTAS_RESPOSTAS", schema = "SISCT")
public class PerguntaResposta {

    @Column(name = "PK_PERGUNTAS")
    private Long pkPerguntas;

    @Id
    @Column(name = "PK_RESPOSTA")
    private Long pkResposta;

    @Column(name = "PERGUNTA")
    private String pergunta;

    @Column(name = "TP_EXIBIR_PERGUNTA")
    private String tipoExibicaoPergunta;

    @Column(name = "CO_DIRECAO")
    private String codigoDirecao;

    @Column(name = "DT_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    @Column(name = "RESPOSTA")
    private String resposta;

    // Getters e Setters
    public Long getPkPerguntas() {
        return pkPerguntas;
    }

    public void setPkPerguntas(Long pkPerguntas) {
        this.pkPerguntas = pkPerguntas;
    }

    public Long getPkResposta() {
        return pkResposta;
    }

    public void setPkResposta(Long pkResposta) {
        this.pkResposta = pkResposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getTipoExibicaoPergunta() {
        return tipoExibicaoPergunta;
    }

    public void setTipoExibicaoPergunta(String tipoExibicaoPergunta) {
        this.tipoExibicaoPergunta = tipoExibicaoPergunta;
    }

    public String getCodigoDirecao() {
        return codigoDirecao;
    }

    public void setCodigoDirecao(String codigoDirecao) {
        this.codigoDirecao = codigoDirecao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}