package br.com.zupacademy.gabrielamartins.casadocodigo.requestDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class EstadoRequestDto {

    @NotBlank
    private String nome;

    @ExistsId(fieldName = "id", domainClass = Pais.class)
    @NotNull
    private Long idPais;


    public EstadoRequestDto(@NotBlank @NotNull String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converteParaEstado(PaisRepository paisRepository){
        @NotNull Pais pais = paisRepository.findById(idPais).get();

        Assert.state(pais!=null, "Este pais não existe no banco de dados " + idPais);

        return new Estado(this.nome, pais);
    }





}
