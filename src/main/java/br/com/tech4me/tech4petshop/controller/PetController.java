package br.com.tech4me.tech4petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4petshop.service.Petservice;
import br.com.tech4me.tech4petshop.shared.PetDto;
import br.com.tech4me.tech4petshop.shared.PetDtoListagem;

@RestController
@RequestMapping("petshop")

public class PetController {

    @Autowired
    private Petservice servico;

     @GetMapping
  public ResponseEntity<List<PetDtoListagem>> obterPets() {
    return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
  }

  
@GetMapping("/{id}")
  public ResponseEntity<PetDto> obterPetPorId(@PathVariable String id) {
    Optional<PetDto> pet = servico.obterPorId(id);

    if (pet.isPresent()) {
      return new ResponseEntity<>(pet.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<PetDto> cadastrarPet(@RequestBody PetDto pet) {
    return new ResponseEntity<>(servico.cadastrar(pet), HttpStatus.CREATED);
  }
}
