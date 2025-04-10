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
 * Entity representing a legal representative in the system
 */
@Data
@Entity
@Table(name = "TB_REPRESENTANTE_LEGAL")
public class RepresentanteLegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_REPRESENTANTE_LEGAL")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_NOME", nullable = false, length = 200)
    private String nome;
    
    @NotNull
    @Column(name = "DT_TERMINO_MANDATO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataTerminoMandato;
    
    @Column(name = "TP_PAPEL_DIRETORIA", length = 1)
    private String tipoPapelDiretoria;
    
    @NotNull
    @Column(name = "DT_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "NU_CPF", length = 11)
    private String cpf;
    
    @Size(max = 50)
    @Column(name = "NR_TELEFONE", length = 50)
    private String numeroTelefone;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NO_EMAIL", nullable = false, length = 100)
    private String email;
    
    @NotNull
    @Column(name = "TP_ESCOLARIDADE", nullable = false, length = 1)
    private String tipoEscolaridade;
    
    @Size(max = 200)
    @Column(name = "DS_PAPEL_DIRETORIA", length = 200)
    private String descricaoPapelDiretoria;
    
    @Size(max = 100)
    @Column(name = "NO_CURSO", length = 100)
    private String nomeCurso;
    
    @NotNull
    @Column(name = "ST_REPRESENTANTE_LEGAL_ATIVO", nullable = false, length = 1)
    private String representanteLegalAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;
    
    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL51"))
    private CadastroNacional cadastroNacional;
}
