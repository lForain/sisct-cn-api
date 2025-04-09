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
 * Entity representing a diligence record in the system
 */
@Data
@Entity
@Table(name = "TB_DILIGENCIA")
public class Diligencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_DILIGENCIA")
    private Integer id;
    
    @Column(name = "DT_ENVIO")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;
    
    @NotNull
    @Column(name = "DT_ULTIMA_ALTERACAO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataUltimaAlteracao;
    
    @NotNull
    @Column(name = "DT_INICIO_DILIGENCIA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicioDiligencia;
    
    @NotNull
    @Size(max = 800)
    @Column(name = "DS_DESCRICAO", nullable = false, length = 800)
    private String descricao;
    
    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;
    
    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false)
    private CadastroNacional cadastroNacional;
    
    @Column(name = "DILIGENCIA_ATIVO", length = 1)
    private String diligenciaAtivo;
}
