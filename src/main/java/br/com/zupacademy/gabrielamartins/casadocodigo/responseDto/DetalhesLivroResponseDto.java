package br.com.zupacademy.gabrielamartins.casadocodigo.responseDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Livro;

import java.time.LocalDate;

public class DetalhesLivroResponseDto {


    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private Double preco;
    private String resumo;
    private String sumario;
    private LocalDate dataPublicacao;
    private DetalhesAutorResponseDto autor;

    public DetalhesLivroResponseDto(Livro livro){
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new DetalhesAutorResponseDto(livro.getAutor());

    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public Double getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalhesAutorResponseDto getAutor() {
        return autor;
    }
}
