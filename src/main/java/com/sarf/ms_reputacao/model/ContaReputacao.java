package com.sarf.ms_reputacao.model;

import jakarta.persistence.*;  // Importa as anotações do JPA
import java.time.LocalDateTime;

// @Entity Essa classe é uma TABELA no banco
@Entity
// @Table(name = "..") 
@Table(name = "conta_reputacao")
public class ContaReputacao {

    // @Id Esse campo é a CHAVE PRIMÁRIA
    @Id
    private String chavePix; 
    
    private int pontuacaoFraude;  // Quantas denúncias tem
    
    private LocalDateTime ultimaDenuncia;  // Última vez que foi denunciado
    
    public ContaReputacao() {
    }
    
    public ContaReputacao(String chavePix, int pontuacaoFraude) {
        this.chavePix = chavePix;
        this.pontuacaoFraude = pontuacaoFraude;
    }
    
    // GETTERS e SETTERS (métodos para pegar e modificar os valores)
    
    public String getChavePix() {
        return chavePix;  // Retorna o valor de chavePix
    }
    
    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;  // Modifica o valor de chavePix
    }
    
    public int getPontuacaoFraude() {
        return pontuacaoFraude;
    }
    
    public void setPontuacaoFraude(int pontuacaoFraude) {
        this.pontuacaoFraude = pontuacaoFraude;
    }
    
    public LocalDateTime getUltimaDenuncia() {
        return ultimaDenuncia;
    }
    
    public void setUltimaDenuncia(LocalDateTime ultimaDenuncia) {
        this.ultimaDenuncia = ultimaDenuncia;
    }
}
    
