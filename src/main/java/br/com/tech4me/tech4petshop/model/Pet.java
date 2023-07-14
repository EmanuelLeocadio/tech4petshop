package br.com.tech4me.tech4petshop.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.tech4petshop.shared.PetDto;
import br.com.tech4me.tech4petshop.shared.PetDtoListagem;

@Document("Pet")
public class Pet {
   @Id
private String Id;
public String getId() {
    return Id;
}
public void setId(String id) {
    Id = id;
}
private String nome;
private String raca;
private int AnodeNascimento;
private Boolean vacinado;
private List<String> procedimentos;

public Pet() {}

  public Pet(PetDto dto) {
    this.Id = dto.id();
    this.nome = dto.nome();
    this.raca = dto.raca();
    this.AnodeNascimento = dto.AnodeNascimento();
    this.vacinado = dto.vacinado();
    this.procedimentos = dto.procedimentos();
  }

public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getRaca() {
    return raca;
}
public void setRaca(String raca) {
    this.raca = raca;
}
public int getAnodeNascimento() {
    return AnodeNascimento;
}
public void setAnodeNascimento(int anodeNascimento) {
    AnodeNascimento = anodeNascimento;
}
public Boolean getVacinado() {
    return vacinado;
}
public void setVacinado(Boolean vacinado) {
    this.vacinado = vacinado;
}
public List<String> getProcedimentos() {
    return procedimentos;
}
public void setProcedimentos(List<String> procedimentos) {
    this.procedimentos = procedimentos;
}
public static boolean isPresent() {
	return false;
}

}
