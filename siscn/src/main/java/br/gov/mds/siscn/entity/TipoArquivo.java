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
 * Entity representing a file type in the system
 */
@Data
@Entity
@Table(name = "TB_TIPO_ARQUIVO")
public class TipoArquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TIPO_ARQUIVO")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_TIPO_ARQUIVO", nullable = false, length = 200)
    private String nomeTipoArquivo;
    
    @NotNull
    @Column(name = "ST_TIPO_ARQUIVO_ATIVO", nullable = false, length = 1)
    private String tipoArquivoAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
