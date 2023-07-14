package br.com.tech4me.tech4petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4petshop.model.Pet;
import br.com.tech4me.tech4petshop.repository.PetRepository;
import br.com.tech4me.tech4petshop.shared.PetDto;
import br.com.tech4me.tech4petshop.shared.PetDtoListagem;

@Service
public class PetServiceImpl implements Petservice{

    @Autowired
    private PetRepository repositorio;

    @Override
    public List<PetDtoListagem> obterTodas() {
       return repositorio.findAll()
       .stream()
       .map(p -> new PetDtoListagem(p.getId(), p.getNome(), p.getProcedimentos()))
       .toList();
             
    }

    @Override
    public Optional<PetDto> obterPorId(String id) {
      Optional<Pet> pet = repositorio.findById(id);
  
      if (pet.isPresent()){
        return Optional.of(new PetDto(pet.get().getId(), 
          pet.get().getNome(), pet.get().getRaca(),
          pet.get().getAnodeNascimento(), pet.get().getVacinado(),
          pet.get().getProcedimentos()));
      } else {
        return Optional.empty();
      }
    }
    @Override
    public PetDto cadastrar(PetDto dto) {
       Pet pet = new Pet(dto);
       repositorio.save(pet);
       return new PetDto(pet.getId(), pet.getNome(), 
       pet.getRaca(), pet.getAnodeNascimento(), pet.getVacinado(),
       pet.getProcedimentos());
   }
    

    @Override
    public Optional<PetDto> atualizarPorId(String id, PetDto dto) {
        Optional<Pet> pet = repositorio.findById(id);

        if (pet.isPresent()) {
          Pet petAtualizar = new Pet(dto);
          petAtualizar.setId(id);
          repositorio.save(petAtualizar);
          return Optional.of(new PetDto(petAtualizar.getId(), petAtualizar.getNome(), petAtualizar.getRaca(), 
          petAtualizar.getAnodeNascimento(), petAtualizar.getVacinado(), petAtualizar.getProcedimentos()));
        } else
          return Optional.empty();
      }
    
        @Override
  public void excluirPorId(String id) {
    repositorio.deleteById(id);
  }
}
   

