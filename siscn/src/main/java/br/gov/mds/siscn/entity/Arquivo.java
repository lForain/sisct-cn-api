package br.gov.mds.siscn.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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
 * Entity representing a file record in the system
 */
@Data
@Entity
@Table(name = "RL_ARQUIVOS")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ARQUIVO")
    private Integer id;
    
    // Add basic file attributes
    @NotNull
    @Size(max = 255)
    @Column(name = "NO_ARQUIVO", nullable = false)
    private String nomeArquivo;
    
    @NotNull
    @Column(name = "DT_UPLOAD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUpload;
    
    @Column(name = "DS_CAMINHO")
    private String caminho;
    
    @Column(name = "ST_ARQUIVO_ATIVO", length = 1)
    private String arquivoAtivo;
    
    // Foreign keys
    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;
    
    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL101"))
    private CadastroNacional cadastroNacional;
    
    @NotNull
    @Column(name = "PK_TIPO_ARQUIVO", nullable = false)
    private Integer tipoArquivoId;
    
    @ManyToOne
    @JoinColumn(name = "PK_TIPO_ARQUIVO", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_TIPO_ARQUIVOS111"))
    private TipoArquivo tipoArquivo;
}
