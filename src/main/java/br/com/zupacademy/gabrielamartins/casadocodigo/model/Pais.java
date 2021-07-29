package br.com.zupacademy.gabrielamartins.casadocodigo.model;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    @Deprecated
    public Pais() {
    }


    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean paisPossuiEstados() {
        return this.estados.size() > 0;
    }
}
