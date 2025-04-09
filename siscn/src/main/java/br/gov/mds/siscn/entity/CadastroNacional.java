package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CADASTRO_NACIONAL")
public class CadastroNacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private Integer id;

    @Column(name = "NU_CNPJ", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "NU_FILIAIS", nullable = false)
    private Integer filiais;

    @Column(name = "NO_FANTASIA", nullable = false, length = 200)
    private String nomeFantasia;

    @Column(name = "NO_RAZAO_SOCIAL", nullable = false, length = 200)
    private String razaoSocial;

    @Column(name = "CO_CNAE_PRINCIPAL", nullable = false, length = 20)
    private String cnaePrincipal;

    @Column(name = "CO_CNAE_SECUNDARIO", nullable = false, length = 20)
    private String cnaeSecundario;

    @Column(name = "VL_RECEITA_BRUTA", nullable = false, precision = 18, scale = 2)
    private BigDecimal receitaBruta;

    @Column(name = "TP_FINANCIAMENTO_UNIAO", nullable = false, length = 1)
    private String financiamentoUniao;

    @Column(name = "TP_FINANCIAMENTO_ESTADO", nullable = false, length = 1)
    private String financiamentoEstado;

    @Column(name = "TP_FINANCIAMENTO_MUNICIPIO", nullable = false, length = 1)
    private String financiamentoMunicipio;

    @Column(name = "NU_MESES_PROJETO")
    private Integer mesesProjeto;

    @Column(name = "TP_POSSUI_CEBAS", nullable = false, length = 1)
    private String possuiCebas;

    @Column(name = "DT_CEBAS_INICIO", nullable = false)
    private LocalDate cebasInicio;

    @Column(name = "DT_CEBAS_FINAL", nullable = false)
    private LocalDate cebasFinal;

    @Column(name = "TP_REQUERIMENTO_CEBAS", nullable = false, length = 1)
    private String requerimentoCebas;

    @Column(name = "NU_CEBAS_ANO_PROTOCOLO")
    private Integer cebasAnoProtocolo;

    @Column(name = "NU_CEBAS_PROTOCOLO")
    private Integer cebasProtocolo;

    @Column(name = "TP_CUMPRE_DISPOSITIVOS", nullable = false, length = 1)
    private String cumpreDispositivos;

    @Column(name = "NU_TOTAL_VAGAS")
    private Integer totalVagas;

    @Column(name = "TP_POSSUI_INS_CONS_MUNICIPAL", nullable = false, length = 1)
    private String possuiInscricaoConselhoMunicipal;

    @Column(name = "TP_CONSELHO_INSCRITO", nullable = false, length = 1)
    private String conselhoInscrito;

    @Column(name = "TP_POSSUI_INS_CONS_ESTADUAL", nullable = false, length = 1)
    private String possuiInscricaoConselhoEstadual;

    @Column(name = "NO_CONSELHO_ESTADUAL", nullable = false, length = 200)
    private String conselhoEstadual;

    @Column(name = "TP_POSSUI_RECON_PUBLICA", nullable = false, length = 1)
    private String possuiReconhecimentoPublico;

    @Column(name = "TP_POSSUI_RECON_PUBLICA_QUAL", length = 1)
    private String possuiReconhecimentoPublicoQual;

    @Column(name = "TP_PERIODICIDADE_CAPACITACAO", nullable = false, length = 1)
    private String periodicidadeCapacitacao;

    @Column(name = "TP_ACOLHIMENTO_PROVISORIO", nullable = false, length = 1)
    private String acolhimentoProvisorio;

    @Column(name = "TP_COMUN_TERAPEUTICA", nullable = false, length = 1)
    private String comunidadeTerapeutica;

    @Column(name = "TP_CAPACIDADE", nullable = false, length = 1)
    private String capacidade;

    @Column(name = "TP_ACESSO_PUBLICO_ALVO", nullable = false, length = 1)
    private String acessoPublicoAlvo;

    @Column(name = "TP_ARTICULACAO", nullable = false, length = 1)
    private String articulacao;

    @Column(name = "DS_ARTICULACAO", nullable = false, length = 200)
    private String descricaoArticulacao;

    @Column(name = "TP_POSSUI_QUADRO_TECNICO", nullable = false, length = 1)
    private String possuiQuadroTecnico;

    @Column(name = "TP_GRATUITO", nullable = false, length = 1)
    private String gratuito;

    @Column(name = "DS_CUSTEIO", nullable = false, length = 200)
    private String descricaoCusteio;

    @Column(name = "TP_PERIODICIDADE_ATIVIDADES", nullable = false, length = 1)
    private String periodicidadeAtividades;

    @Column(name = "DS_PERIODICIDADE_ATIVIDADES", nullable = false, length = 200)
    private String descricaoPeriodicidadeAtividades;

    @Column(name = "TP_CONTROLE_PUBLICO_ALVO", nullable = false, length = 1)
    private String controlePublicoAlvo;

    @Column(name = "TP_POSSUI_SICAF", nullable = false, length = 1)
    private String possuiSicaf;

    @Column(name = "NU_STATUS", nullable = false)
    private Integer status;

    @Column(name = "ST_CADASTRO_NACIONAL_ATIVO", nullable = false, length = 1)
    private String cadastroNacionalAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}
