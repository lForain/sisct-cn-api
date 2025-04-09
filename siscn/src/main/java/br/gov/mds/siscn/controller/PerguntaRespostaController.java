package br.gov.mds.siscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.siscn.dto.PerguntaRespostaViewDto;
import br.gov.mds.siscn.service.PerguntaRespostaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/perguntas-respostas")
@Tag(name = "Perguntas e Respostas", description = "API para consulta de perguntas e respostas cadastradas")
public class PerguntaRespostaController {

    private final PerguntaRespostaService perguntaRespostaService;

    @Autowired
    public PerguntaRespostaController(PerguntaRespostaService perguntaRespostaService) {
        this.perguntaRespostaService = perguntaRespostaService;
    }

    @Operation(summary = "Listar todas as perguntas e respostas", description = "Retorna todas as perguntas cadastradas com suas respectivas respostas", responses = {
            @ApiResponse(responseCode = "200", description = "Lista de perguntas e respostas encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerguntaRespostaViewDto.class))) })
    @GetMapping
    public ResponseEntity<List<PerguntaRespostaViewDto>> getAllPerguntasRespostas() {
        List<PerguntaRespostaViewDto> result = perguntaRespostaService.findAllGroupedByPergunta();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Buscar perguntas e respostas por ID da pergunta", description = "Retorna a pergunta específica e todas as suas respostas associadas", responses = {
            @ApiResponse(responseCode = "200", description = "Pergunta e respostas encontradas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerguntaRespostaViewDto.class))),
            @ApiResponse(responseCode = "404", description = "Pergunta não encontrada", content = @Content)
    })
    @GetMapping("/{pkPerguntas}")
    public ResponseEntity<PerguntaRespostaViewDto> getPerguntaRespostaByPkPerguntas(
            @Parameter(description = "ID da pergunta a ser buscada", example = "1", required = true) @PathVariable Long pkPerguntas) {

        PerguntaRespostaViewDto result = perguntaRespostaService.findByPkPergunta(pkPerguntas);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
}