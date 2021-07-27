package br.com.zupacademy.gabrielamartins.casadocodigo.responseDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;

public class DetalhesAutorResponseDto {

    private String nome;
    private String descricao;

    public DetalhesAutorResponseDto(Autor autor){
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
