package br.gov.mds.siscn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RL_ARQUIVOS")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ARQUIVOS", nullable = false)
    private Integer id;

    @Column(name = "NU_DIAS_VALIDADE")
    private Integer diasValidade;

    @Column(name = "DT_VALIDADE")
    private LocalDate dataValidade;

    @Column(name = "DS_ARQUIVO_URL", nullable = false, length = 400)
    private String arquivoUrl;

    @Column(name = "DS_COMPLEMENTO", nullable = false, length = 200)
    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", nullable = false)
    private CadastroNacional cadastroNacional;

    @Column(name = "PK_TIPO_ARQUIVO", nullable = false)
    private Integer tipoArquivo;

    @Column(name = "ST_ARQUIVO_ATIVO", nullable = false, length = 1)
    private String arquivoAtivo;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}
