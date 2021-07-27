package br.com.zupacademy.gabrielamartins.casadocodigo.requestDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Livro;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.ObjectNotFoundException;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.swing.text.html.Option;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequestDto {

    @NotBlank
    @UniqueValue(fieldName = "titulo", domainClass = Livro.class)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(value = 20, message = "Preço mínimo de R$ 20,00")
    private Double preco;
    @NotNull
    @Min(value = 100, message = "Quantidade mínima é 100 unidades")
    private Integer numeroPaginas;
    @NotBlank
    @UniqueValue(fieldName = "isbn", domainClass = Livro.class)
    private String isbn;
    @Future(message = "Esta data precisa ser no futuro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Categoria.class)
    private Long idCategoria;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Autor.class)
    private Long idAutor;

    public LivroRequestDto(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
                           @NotNull Double preco, @NotNull Integer numeroPaginas, @NotBlank String isbn,
                           @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro converteParaLivro(EntityManager manager){
        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(autor!=null, "Este autor não existe no banco de dados " + idAutor);
        Assert.state(categoria!=null, "Esta categoria não existe no banco de dados " + idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco,
                this.numeroPaginas, this.isbn, this.dataPublicacao, autor, categoria);
    }
}
