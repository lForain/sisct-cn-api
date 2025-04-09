package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private CadastroNacional cadastroNacional;

    @Column(name = "PK_PROFISSAO", nullable = false)
    private Integer profissao;

    @Column(name = "PK_VINCULO", nullable = false)
    private Integer vinculo;
}
