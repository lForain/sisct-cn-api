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
 * Entity representing a type of service/attendance in the system
 */
@Data
@Entity
@Table(name = "TB_TIPO_ATENDIMENTO")
public class TipoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TIPO_ATENDIMENTO")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_NOME", nullable = false, length = 200)
    private String nome;
    
    @NotNull
    @Column(name = "NU_GRUPO", nullable = false)
    private Integer numeroGrupo;
    
    @NotNull
    @Column(name = "ST_TIPO_ATENDIMENTO_ATIVO", nullable = false, length = 1)
    private String tipoAtendimentoAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
