package br.com.zupacademy.gabrielamartins.casadocodigo.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    @ManyToOne
    @Valid
    private Pais pais;


    public Estado() {
    }

    public Estado(@NotBlank @NotNull String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }


    private boolean pertenceAoPais(Long idPais) {
        return this.pais.getId() == idPais;
    }

    public boolean naoPertenceAoPais(Long id) {
        Assert.notNull(pais, "Não podemos ter um país nulo para fazer a comparação" );
        return !pertenceAoPais(id);
    }

}
