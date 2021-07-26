package br.com.zupacademy.gabrielamartins.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @NotNull
    private LocalDateTime dataDoRegistro = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }


    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(Long id, String nome, String email, String descricao, LocalDateTime dataDoRegistro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataDoRegistro = dataDoRegistro;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getDataDoRegistro() {
        return dataDoRegistro;
    }
}
