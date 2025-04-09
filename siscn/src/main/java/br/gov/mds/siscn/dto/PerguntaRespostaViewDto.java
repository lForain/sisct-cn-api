package br.gov.mds.siscn.dto;
import java.util.List;

public class PerguntaRespostaViewDto {
    private String id;
    private String nome;
    private String direcao;
    private List<RespostaViewDto> respostas;

    // Construtores
    public PerguntaRespostaViewDto() {
    }

    public PerguntaRespostaViewDto(String id, String nome, String direcao, List<RespostaViewDto> respostas) {
        this.id = id;
        this.nome = nome;
        this.direcao = direcao;
        this.respostas = respostas;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public List<RespostaViewDto> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaViewDto> respostas) {
        this.respostas = respostas;
    }
}