package br.com.zupacademy.gabrielamartins.casadocodigo.responseDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Cliente;

public class ClienteResponseDto {

    private Long id;

    public ClienteResponseDto(Cliente cliente){
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
