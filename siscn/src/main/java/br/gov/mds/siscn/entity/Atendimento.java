package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;

    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL121"))
    private CadastroNacional cadastroNacional;

    @NotNull
    @Column(name = "PK_TIPO_ATENDIMENTO", nullable = false)
    private Integer tipoAtendimentoId;

    @ManyToOne
    @JoinColumn(name = "PK_TIPO_ATENDIMENTO", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_TIPO_ATENDIMENTO131"))
    private TipoAtendimento tipoAtendimento;
}
