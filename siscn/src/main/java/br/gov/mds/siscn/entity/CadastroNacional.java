package br.gov.mds.siscn.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.gov.mds.siscn.service.FieldMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_CADASTRO_NACIONAL")
public class CadastroNacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @FieldMetadata(label = "Matrícula", order = 1, required = true)
    @Column(name = "ID_CADASTRO_NACIONAL")
    private Integer id;

    @Column(name = "CO_CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "CO_TIPO_ENTIDADE")
    private Integer tipoEntidade;

    @FieldMetadata(label = "Número de Filiais", order = 4, required = false)
    @Column(name = "NR_FILIAIS")
    private Integer numeroFiliais;

    @Column(name = "NO_NOME_FANTASIA", length = 200)
    private String nomeFantasia;

    @FieldMetadata(label = "Razão Social ", order = 1, required = false)
    @Column(name = "NO_RAZAO_SOCIAL", length = 200)
    private String razaoSocial;

    @Column(name = "CO_CNAE_PRINCIPAL", length = 50)
    private String cnaePrincipal;

    @Column(name = "CO_CNAE_SECUNDARIO", length = 50)
    private String cnaeSecundario;

    @Column(name = "VL_RECEITA_BRUTA", precision = 18, scale = 2)
    private BigDecimal receitaBruta;

    @Column(name = "TP_MODALIDADE_FINANCIAMENTO")
    private Integer modalidadeFinanciamento;

    @Column(name = "CO_MODALIDADE")
    private Integer modalidade;

    @Column(name = "CO_MODALIDADE_OUTROS")
    private Integer modalidadeOutros;

    @Column(name = "TP_FINANCIAMENTO_ESTADO")
    private Integer financiamentoEstado;

    @Column(name = "CO_FINANCIAMENTO_ESTADO", length = 50)
    private String financiamentoEstadoCodigo;

    @Column(name = "TP_FINANCIAMENTO_MUNICIPIO")
    private Integer financiamentoMunicipio;

    @Column(name = "CO_FINANCIAMENTO_MUNICIPIO")
    private Integer financiamentoMunicipioCodigo;

    @Column(name = "TP_DOACOES_OUTRAS")
    private Integer doacoesOutras;

    @Column(name = "ED_DOACOES_OUTRAS_DETALHES", length = 100)
    private String doacoesOutrasDetalhes;

    @Column(name = "VL_DOACOES_OUTRAS_MEDIA", precision = 18, scale = 2)
    private BigDecimal doacoesOutrasMedia;

    @Column(name = "TP_DOACOES_OUTRAS_RECEITAS")
    private Integer doacoesOutrasReceitas;

    @Column(name = "VL_DOACOES_OUTRAS_RECEITAS_MEDIA")
    private Integer doacoesOutrasReceitasMedia;

    @Column(name = "ED_DOACOES_OUTRAS_RECEITAS_OUTRAS", length = 50)
    private String doacoesOutrasReceitasOutras;

    @Column(name = "VL_DOACOES_OUTRAS_MEDIA_2", precision = 18, scale = 2)
    private BigDecimal doacoesOutrasMedia2;

    @Column(name = "DS_URL_LICENCA_SANITARIA", length = 400)
    private String urlLicencaSanitaria;

    @Column(name = "DT_VALIDADE_LICENCA_SANITARIA")
    private LocalDate validadeLicencaSanitaria;

    @FieldMetadata(label = "Prazo de permanência", order = 5, required = false)
    @Column(name = "NR_PRAZO_PROJETO")
    private Integer prazoProjeto;

    @Column(name = "DS_URL_PROJETO_TERAPEUTICO", length = 400)
    private String urlProjetoTerapeutico;

    @Column(name = "TP_POSSUI_CEBAS")
    private Integer possuiCebas;

    @Column(name = "DT_INICIO_VALIDADE_CEBAS")
    private LocalDate inicioValidadeCebas;

    @Column(name = "DT_FIM_VALIDADE_CEBAS")
    private LocalDate fimValidadeCebas;

    @Column(name = "DS_URL_DOCUMENTO_CEBAS", length = 400)
    private String urlDocumentoCebas;

    @Column(name = "TP_CEBAS_DEPAD")
    private Integer cebasDepad;

    @Column(name = "NU_ANO_PROTOCOLO_CEBAS")
    private Integer anoProtocoloCebas;

    @Column(name = "NU_PROTOCOLO_CEBAS")
    private Integer protocoloCebas;

    @Column(name = "TP_CUMPRE_CONAD")
    private Integer cumpreConad;

    @Column(name = "NU_TOTAL_VAGAS")
    private Integer totalVagas;
}
