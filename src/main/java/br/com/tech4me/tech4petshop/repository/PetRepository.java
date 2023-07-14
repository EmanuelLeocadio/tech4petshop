package br.com.tech4me.tech4petshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.tech4petshop.model.Pet;

@Repository

public interface PetRepository extends MongoRepository<Pet, String>{
    
}
