package br.gov.mds.siscn.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * Entity representing a system log entry
 */
@Data
@Entity
@Table(name = "TB_LOG")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_LOG")
    private Integer id;
    
    @NotNull
    @Column(name = "DT_DATA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_DESCRICAO", nullable = false, length = 200)
    private String descricao;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NO_USUARIO", nullable = false, length = 100)
    private String nomeUsuario;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "NO_MODULO", nullable = false, length = 200)
    private String nomeModulo;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_VALOR", nullable = false, length = 200)
    private String valor;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "DS_COMPLEMENTO", nullable = false, length = 200)
    private String complemento;
}
