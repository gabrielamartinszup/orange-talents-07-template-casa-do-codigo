package br.com.zupacademy.gabrielamartins.casadocodigo.responseDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Categoria;

public class CategoriaResponseDto {

    private Long id;
    private String nome;

    public CategoriaResponseDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
