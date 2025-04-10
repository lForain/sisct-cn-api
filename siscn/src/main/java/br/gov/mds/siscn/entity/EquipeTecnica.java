package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RL_EQUIPE_TECNICA")
public class EquipeTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_EQUIPE_TECNICA", nullable = false)
    private Integer id;

    @Column(name = "NO_NOME", nullable = false, length = 200)
    private String nome;

    @Column(name = "NU_CARGA_HORARIA", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "ST_EQUIPE_TECNICA_ATIVO", nullable = false, length = 1)
    private String equipeTecnicaAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;

    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL161"))
    private CadastroNacional cadastroNacional;

    @NotNull
    @Column(name = "PK_PROFISSAO", nullable = false)
    private Integer profissaoId;

    @ManyToOne
    @JoinColumn(name = "PK_PROFISSAO", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_PROFISSAO171"))
    private Profissao profissao;

    @NotNull
    @Column(name = "PK_VINCULO", nullable = false)
    private Integer vinculoId;

    @ManyToOne
    @JoinColumn(name = "PK_VINCULO", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_VINCULO181"))
    private Vinculo vinculo;
}
