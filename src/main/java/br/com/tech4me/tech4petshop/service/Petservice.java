package br.com.tech4me.tech4petshop.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4petshop.shared.PetDto;
import br.com.tech4me.tech4petshop.shared.PetDtoListagem;

public interface Petservice {
    List<PetDtoListagem> obterTodas();
    Optional<PetDto> obterPorId(String id);
    PetDto cadastrar(PetDto dto);
    Optional<PetDto> atualizarPorId(String id, PetDto dto);
    void excluirPorId(String id);
    
}
