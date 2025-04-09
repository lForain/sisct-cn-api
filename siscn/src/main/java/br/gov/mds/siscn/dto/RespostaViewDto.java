package br.gov.mds.siscn.dto;

public class RespostaViewDto {
    private Long id;
    private String descricao;
    private boolean selecionado;

    // Construtores
    public RespostaViewDto() {
        this.selecionado = false; // Valor padrão
    }

    public RespostaViewDto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.selecionado = false; // Valor padrão
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
}