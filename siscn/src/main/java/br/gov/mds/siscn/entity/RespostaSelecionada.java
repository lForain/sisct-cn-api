package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;

    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL231"))
    private CadastroNacional cadastroNacional;

    @NotNull
    @Column(name = "PK_RESPOSTA", nullable = false)
    private Integer respostaId;

    @ManyToOne
    @JoinColumn(name = "PK_RESPOSTA", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_RESPOSTA221"))
    private Resposta resposta;
}
