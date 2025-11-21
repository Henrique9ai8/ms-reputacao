package com.sarf.ms_reputacao.repository;

import com.sarf.ms_reputacao.model.ContaReputacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository diz:essa interface acessa o banco de dados
@Repository
// JpaRepository<[Entidade], [Tipo da Chave Primária]>
public interface ContaReputacaoRepository extends JpaRepository<ContaReputacao, String> {
}