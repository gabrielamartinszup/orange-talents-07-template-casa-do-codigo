package br.com.zupacademy.gabrielamartins.casadocodigo.requestDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorRequestDto {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;


    public AutorRequestDto() {
    }

    public AutorRequestDto(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converteParaAutor(){
        return new Autor(this.nome, this.email, this.descricao);
    }
}
