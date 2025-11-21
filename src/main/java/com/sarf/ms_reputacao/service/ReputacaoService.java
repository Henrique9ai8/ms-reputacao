package com.sarf.ms_reputacao.service;

import com.sarf.ms_reputacao.model.ContaReputacao;
import com.sarf.ms_reputacao.repository.ContaReputacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// @Service diz:Essa classe tem lógica de negócio
@Service
public class ReputacaoService {

    // @Autowired: O Spring INJETA automaticamente o Repository aqui
    @Autowired
    private ContaReputacaoRepository repository;

    // Método 1: Buscar reputação de uma chave Pix
    public ContaReputacao buscarReputacao(String chavePix) {
        // Validação: garante que chavePix não é null
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave Pix não pode ser nula ou vazia");
        }
        
        // Tenta buscar no banco
        // Se não achar, cria uma nova com pontuação 0
        return repository.findById(chavePix)
                .orElse(new ContaReputacao(chavePix, 0));
    }

    // Método 2: Registrar uma denúncia (aumenta pontuação)
    public ContaReputacao denunciarConta(String chavePix) {
        // Validação
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave Pix não pode ser nula ou vazia");
        }
        
        // Busca a conta (ou cria se não existir)
        ContaReputacao conta = buscarReputacao(chavePix);

        // Aumenta a pontuação em 1
        conta.setPontuacaoFraude(conta.getPontuacaoFraude() + 1);

        // Registra a data da denúncia
        conta.setUltimaDenuncia(LocalDateTime.now());

        // Salva no banco e retorna
        return repository.save(conta);
    }
}