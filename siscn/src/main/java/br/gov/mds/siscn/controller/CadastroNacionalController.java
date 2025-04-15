package br.gov.mds.siscn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.siscn.service.CadastroNacionalService;

@RestController
@RequestMapping("/api/cadastro-nacional")
public class CadastroNacionalController {

    @Autowired
    private CadastroNacionalService cadastroNacionalService;

    @GetMapping("/validar/{cnpj}")
    public List<String> validaCadastro(@PathVariable String cnpj) {
        return cadastroNacionalService.validaCadastro(cnpj);
    }
}