package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RL_RESPOSTA_SELECIONADA")
public class RespostaSelecionada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_RESPOSTA_SELECIONADA", nullable = false)
    private Integer id;

    @Column(name = "DS_COMPLEMENTO", length = 200)
    private String complemento;

    @Column(name = "ST_RESPOSTA_SELECIONADA_ATIVO", nullable = false, length = 1)
    private String respostaSelecionadaAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(name = "PK_RESPOSTA", nullable = false)
    private Integer resposta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private CadastroNacional cadastroNacional;
}
