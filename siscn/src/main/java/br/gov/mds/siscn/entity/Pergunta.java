package br.gov.mds.siscn.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * Entity representing a question in the system
 */
@Data
@Entity
@Table(name = "TB_PERGUNTA")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PERGUNTAS")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_PERGUNTA", nullable = false, length = 200)
    private String nomePergunta;
    
    @NotNull
    @Column(name = "CO_DIRECAO", nullable = false)
    private Integer codigoDirecao;
    
    @NotNull
    @Column(name = "TP_EXIBIR_PERGUNTA", nullable = false, length = 1)
    private String tipoExibirPergunta;
    
    @NotNull
    @Column(name = "ST_PERGUNTA_ATIVO", nullable = false, length = 1)
    private String perguntaAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
