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
 * Entity representing an address record in the system
 */
@Data
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ENDERECO")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_LOGRADOURO", nullable = false, length = 200)
    private String logradouro;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_COMPLEMENTO", nullable = false, length = 200)
    private String complemento;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NO_BAIRRO", nullable = false, length = 100)
    private String bairro;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "NU_NUMERO", nullable = false, length = 50)
    private String numero;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "NU_CEP", nullable = false, length = 50)
    private String cep;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @Column(name = "ST_ENDERECO_ATIVO", length = 1)
    private String enderecoAtivo;
    
    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;
    
    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false)
    private CadastroNacional cadastroNacional;
}
