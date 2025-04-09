package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RL_ATENDIMENTO")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ATENDIMENTO", nullable = false)
    private Integer id;

    @Column(name = "NO_NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "ST_ATENDIMENTO_ATIVO", nullable = false, length = 1)
    private String atendimentoAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private CadastroNacional cadastroNacional;

    @Column(name = "PK_TIPO_ATENDIMENTO", nullable = false)
    private Integer tipoAtendimento;
}
