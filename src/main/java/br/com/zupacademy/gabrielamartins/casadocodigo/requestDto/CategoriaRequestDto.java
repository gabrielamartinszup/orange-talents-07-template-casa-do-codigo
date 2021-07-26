package br.com.zupacademy.gabrielamartins.casadocodigo.requestDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequestDto {

    @NotNull
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;


    public CategoriaRequestDto() {
    }

    public CategoriaRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converteParaCategoria(){
        return new Categoria(this.nome);
    }

}
