package br.com.tech4me.tech4petshop.shared;

import java.util.List;

import org.springframework.data.annotation.Id;

public record PetDto(String id,
String nome, String raca, int AnodeNascimento,
Boolean vacinado, List<String> procedimentos){
    
}
