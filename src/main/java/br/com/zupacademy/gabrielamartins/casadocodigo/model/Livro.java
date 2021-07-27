package br.com.zupacademy.gabrielamartins.casadocodigo.model;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    private Double preco;
    @NotNull
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
                 @NotNull Double preco, @NotNull Integer numeroPaginas, @NotBlank String isbn,
                 LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
