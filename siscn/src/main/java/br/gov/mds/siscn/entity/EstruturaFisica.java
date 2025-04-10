package br.gov.mds.siscn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

/**
 * Entity representing the physical structure information of an organization
 */
@Data
@Entity
@Table(name = "TB_ESTRUTURA_FISICA")
public class EstruturaFisica {

    @Id
    @Column(name = "PK_CADASTRO_NACIONAL")
    private Integer id;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "PK_CADASTRO_NACIONAL")
    private CadastroNacional cadastroNacional;
    
    @NotNull
    @Column(name = "TP_ESPACO_ENTIDADE", nullable = false, length = 1)
    private String tipoEspacoEntidade;
    
    @NotNull
    @Column(name = "TP_ESPACO_FAMILIA", nullable = false, length = 1)
    private String tipoEspacoFamilia;
    
    @NotNull
    @Column(name = "TP_ESPACO_INDIVIDUAL", nullable = false, length = 1)
    private String tipoEspacoIndividual;
}
