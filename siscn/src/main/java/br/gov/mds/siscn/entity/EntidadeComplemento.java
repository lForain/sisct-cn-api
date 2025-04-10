package br.gov.mds.siscn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * Entity representing complementary information about an organization
 */
@Data
@Entity
@Table(name = "TB_ENTIDADE_COMPLEMENTO")
public class EntidadeComplemento {

    @Id
    @Column(name = "PK_CADASTRO_NACIONAL")
    private Integer id;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "PK_CADASTRO_NACIONAL", 
                foreignKey = @ForeignKey(name = "RefTB_CADASTRO_NACIONAL241"))
    private CadastroNacional cadastroNacional;
    
    @NotNull
    @Column(name = "TP_DOZE_PASSOS", nullable = false, length = 1)
    private String tipoDozePassos;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_DOZE_PASSOS", nullable = false, length = 200)
    private String descricaoDozePassos;
    
    @NotNull
    @Column(name = "TP_APOIO_DOZE_PASSOS", nullable = false, length = 1)
    private String tipoApoioDozePassos;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_APOIO_DOZE_PASSOS", nullable = false, length = 200)
    private String descricaoApoioDozePassos;
    
    @NotNull
    @Column(name = "TP_ATENDIMENTO_PSICOSOCIAL", nullable = false, length = 1)
    private String tipoAtendimentoPsicosocial;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_ATENDIMENTO_PSICOSOCIAL", nullable = false, length = 200)
    private String descricaoAtendimentoPsicosocial;
    
    @NotNull
    @Column(name = "TP_ATIV_RESSOCIALI", nullable = false, length = 1)
    private String tipoAtividadeRessocializacao;
    
    @NotNull
    @Column(name = "TP_POSSUI_PARCERIAS", nullable = false, length = 1)
    private String tipoPossuiParcerias;
}
