package br.gov.mds.siscn.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * Entity representing an answer option for a question
 */
@Data
@Entity
@Table(name = "TB_RESPOSTA")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_RESPOSTA")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_NOME", nullable = false, length = 200)
    private String nome;
    
    @NotNull
    @Column(name = "ST_RESPOSTA_ATIVO", nullable = false, length = 1)
    private String respostaAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @NotNull
    @Column(name = "PK_PERGUNTAS", nullable = false)
    private Integer perguntaId;
    
    @ManyToOne
    @JoinColumn(name = "PK_PERGUNTAS", insertable = false, updatable = false)
    private Pergunta pergunta;
}
