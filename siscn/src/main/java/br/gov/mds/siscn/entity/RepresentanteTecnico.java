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
 * Entity representing a technical representative in the system
 */
@Data
@Entity
@Table(name = "TB_REPRESENTANTE_TECNICO")
public class RepresentanteTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_REPRESENTANTE_TECNICO")
    private Integer id;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_NOME", nullable = false, length = 200)
    private String nome;
    
    @NotNull
    @Column(name = "DT_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @NotNull
    @Column(name = "NU_CPF", nullable = false, length = 11)
    private String cpf;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NR_TELEFONE", nullable = false, length = 100)
    private String numeroTelefone;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_EMAIL", nullable = false, length = 200)
    private String email;
    
    @Column(name = "TP_ESCOLARIDADE", length = 1)
    private String tipoEscolaridade;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_CURSO", nullable = false, length = 200)
    private String nomeCurso;
    
    @Column(name = "TP_POSSUI_EXPERIENCIA", length = 1)
    private String tipoPossuiExperiencia;
    
    @Column(name = "NU_RESPONSAVEL")
    private Integer numeroResponsavel;
    
    @NotNull
    @Column(name = "ST_REPRESENTANTE_TECNICO_ATIVO", nullable = false, length = 1)
    private String representanteTecnicoAtivo;
    
    @NotNull
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;
    
    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false)
    private CadastroNacional cadastroNacional;
}
