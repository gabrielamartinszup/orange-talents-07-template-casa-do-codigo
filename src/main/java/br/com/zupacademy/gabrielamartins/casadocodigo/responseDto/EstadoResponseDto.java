package br.com.zupacademy.gabrielamartins.casadocodigo.responseDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;

public class EstadoResponseDto {

    private Long id;
    private String nome;

    public EstadoResponseDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
