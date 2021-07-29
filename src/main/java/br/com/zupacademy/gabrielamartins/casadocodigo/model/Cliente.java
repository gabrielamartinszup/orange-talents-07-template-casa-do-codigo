package br.com.zupacademy.gabrielamartins.casadocodigo.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    @ManyToOne
    private Estado estado;
    @NotNull
    @ManyToOne@JoinColumn(nullable = false)
    private Pais pais;



    public Cliente() {
    }


   public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String cep, Pais pais) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
    }



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public Estado getEstado() {
        return estado;
    }


    public void setEstado(Estado estado) {
        Assert.notNull(estado, "O estado em questão não existe");
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }
}
