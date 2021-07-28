package br.com.zupacademy.gabrielamartins.casadocodigo.requestDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequestDto {

    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Pais.class)
    private String nome;



    public String getNome() {
        return nome;
    }

    public Pais converteParaPais(){
        return new Pais(this.nome);

    }
}
