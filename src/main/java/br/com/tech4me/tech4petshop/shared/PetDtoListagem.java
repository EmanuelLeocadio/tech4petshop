package br.com.tech4me.tech4petshop.shared;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public record PetDtoListagem( String id, String nome,
 List<String> procedimentos) {
    
}