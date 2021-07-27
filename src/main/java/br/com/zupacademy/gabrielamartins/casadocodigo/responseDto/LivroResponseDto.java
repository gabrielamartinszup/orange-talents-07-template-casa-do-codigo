package br.com.zupacademy.gabrielamartins.casadocodigo.responseDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseDto {


    private Long id;

    private String titulo;

    private LocalDate dataPublicacao;


    public LivroResponseDto(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.dataPublicacao =  livro.getDataPublicacao();
    }

    public static List<LivroResponseDto> converteParaListaResponseDto(List<Livro> livros) {
        return livros.stream().map(LivroResponseDto::new).collect(Collectors.toList());

    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
}
