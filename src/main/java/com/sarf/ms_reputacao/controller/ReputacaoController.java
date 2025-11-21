package com.sarf.ms_reputacao.controller;

import com.sarf.ms_reputacao.model.ContaReputacao;
import com.sarf.ms_reputacao.service.ReputacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController Essa classe responde requisições HTTP
@RestController
// @RequestMapping: Todas as URLs começam com /api/reputacao
@RequestMapping("/api/reputacao")
public class ReputacaoController {

    @Autowired
    private ReputacaoService service;

    // Endpoint 1: GET - Buscar reputação de uma chave Pix
    @GetMapping("/{chavePix}")
    public ResponseEntity<ContaReputacao> buscarReputacao(@PathVariable String chavePix) {
        ContaReputacao conta = service.buscarReputacao(chavePix);
        return ResponseEntity.ok(conta);
    }

    // Endpoint 2: POST - Denunciar uma conta
    @PostMapping("/denunciar/{chavePix}")
    public ResponseEntity<ContaReputacao> denunciarConta(@PathVariable String chavePix) {
        ContaReputacao conta= service.denunciarConta(chavePix);
        return ResponseEntity.ok(conta);
    }
}