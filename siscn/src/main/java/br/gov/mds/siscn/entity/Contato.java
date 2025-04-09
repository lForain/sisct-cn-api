package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RL_CONTATOS")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_RLCONTATOS", nullable = false)
    private Integer id;

    @Column(name = "CO_CONTATO", nullable = false, length = 200)
    private String contato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private CadastroNacional cadastroNacional;

    @Column(name = "PK_TIPO_CONTATO", nullable = false)
    private Integer tipoContato;

    @Column(name = "ST_CONTATO_ATIVO", nullable = false, length = 1)
    private String contatoAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}
