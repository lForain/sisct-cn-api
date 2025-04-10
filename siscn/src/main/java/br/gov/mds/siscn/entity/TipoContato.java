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
 * Entity representing a contact type in the system
 */
@Data
@Entity
@Table(name = "TB_TIPO_CONTATO")
public class TipoContato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TIPO_CONTATO")
    private Integer id;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NO_TIPO_CONTATO", nullable = false, length = 100)
    private String nomeTipoContato;
    
    @NotNull
    @Column(name = "ST_TIPO_CONTATO", nullable = false, length = 1)
    private String tipoContatoAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
