package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RL_MAPA_VAGAS")
public class MapaVagas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_MAPA_VAGAS", nullable = false)
    private Integer id;

    @Column(name = "NU_DISPONIBILIDADE", nullable = false)
    private Integer disponibilidade;

    @Column(name = "NU_PUBLICO", nullable = false)
    private Integer publico;

    @Column(name = "ST_MAPA_VAGAS_ATIVO", nullable = false, length = 1)
    private String mapaVagasAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    @NotNull
    @Column(name = "PK_TIPO_FINANCIAMENTO", nullable = false)
    private Integer tipoFinanciamentoId;

    @ManyToOne
    @JoinColumn(name = "PK_TIPO_FINANCIAMENTO", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_TIPO_FINANCIAMENTO141"))
    private TipoFinanciamento tipoFinanciamento;

    @NotNull
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer cadastroNacionalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", insertable = false, updatable = false, 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL151"))
    private CadastroNacional cadastroNacional;
}
