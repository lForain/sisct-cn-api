package br.gov.mds.siscn.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.siscn.dto.PerguntaRespostaViewDto;
import br.gov.mds.siscn.dto.RespostaViewDto;
import br.gov.mds.siscn.entity.PerguntaResposta;
import br.gov.mds.siscn.repository.PerguntaRespostaRepository;

@Service
public class PerguntaRespostaService {

    private final PerguntaRespostaRepository repository;

    @Autowired
    public PerguntaRespostaService(PerguntaRespostaRepository repository) {
        this.repository = repository;
    }

    public PerguntaRespostaViewDto findByPkPergunta(Long pkPergunta) {
        // Busca os itens da view
        List<PerguntaResposta> items = repository.findByPkPerguntas(pkPergunta);

        if (items.isEmpty()) {
            return null;
        }

        // Filtra respostas únicas pelo PK_RESPOSTA
        Map<Long, RespostaViewDto> respostasUnicas = new LinkedHashMap<>();
        System.err.println("items.size() = " + items.get(0).getPkResposta() + " - " + items.get(0).getResposta());
        System.err.println("items.size() = " + items.get(1).getResposta() + " - " + items.get(0).getResposta());
        System.err.println("items.size() = " + items.get(2).getResposta() + " - " + items.get(0).getResposta());
        for (PerguntaResposta item : items) {
            System.err.println("item.getPkResposta() = " + item.getPkResposta());
            if (item.getPkResposta() != null && !respostasUnicas.containsKey(item.getPkResposta())) {
                respostasUnicas.put(item.getPkResposta(),
                        new RespostaViewDto(item.getPkResposta(), item.getResposta()));
            }
        }

        return new PerguntaRespostaViewDto(
                items.get(0).getPkPerguntas().toString(),
                items.get(0).getPergunta(),
                items.get(0).getCodigoDirecao(),
                new ArrayList<>(respostasUnicas.values()));
    }

    public List<PerguntaRespostaViewDto> findAllGroupedByPergunta() {
        List<PerguntaResposta> allItems = repository.findAllFromView(); // Usa o novo método

        Map<Long, PerguntaRespostaViewDto> perguntasMap = new LinkedHashMap<>();

        for (PerguntaResposta item : allItems) {
            perguntasMap.putIfAbsent(item.getPkPerguntas(), new PerguntaRespostaViewDto(
                    item.getPkPerguntas().toString(),
                    item.getPergunta(),
                    item.getCodigoDirecao(),
                    new ArrayList<>()));

            if (item.getPkResposta() != null) {
                // Verifica se a resposta já foi adicionada
                boolean respostaJaExiste = perguntasMap.get(item.getPkPerguntas())
                        .getRespostas()
                        .stream()
                        .anyMatch(r -> r.getId().equals(item.getPkResposta()));

                if (!respostaJaExiste) {
                    perguntasMap.get(item.getPkPerguntas()).getRespostas().add(
                            new RespostaViewDto(item.getPkResposta(), item.getResposta()));
                }
            }
        }

        return new ArrayList<>(perguntasMap.values());
    }
}