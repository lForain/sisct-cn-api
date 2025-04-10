package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;

    @ManyToOne
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL31"))
    private CadastroNacional cadastroNacional;

    @NotNull
    @Column(name = "PK_TIPO_CONTATO", nullable = false)
    private Integer tipoContatoId;

    @ManyToOne
    @JoinColumn(name = "PK_TIPO_CONTATO", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_TIPO_CONTATO41"))
    private TipoContato tipoContato;

    @Column(name = "ST_CONTATO_ATIVO", nullable = false, length = 1)
    private String contatoAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}
