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
 * Entity representing a profession in the system
 */
@Data
@Entity
@Table(name = "TB_PROFISSAO")
public class Profissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PROFISSAO")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_PROFISSAO", nullable = false, length = 200)
    private String nomeProfissao;
    
    @NotNull
    @Column(name = "ST_PROFISSAO_ATIVO", nullable = false, length = 1)
    private String profissaoAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
