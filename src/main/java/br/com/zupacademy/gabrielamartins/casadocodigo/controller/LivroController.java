package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Livro;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.LivroRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.DetalhesLivroResponseDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.LivroResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public List<LivroResponseDto> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return LivroResponseDto.converteParaListaResponseDto(livros);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetalhesLivroResponseDto> detalhesDoLivro(@PathVariable Long id){

        Optional <Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()){
            return ResponseEntity.ok(new DetalhesLivroResponseDto(livro.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponseDto> cadastrarLivro(@RequestBody @Valid LivroRequestDto requestDto){

        Livro livro = requestDto.converteParaLivro(manager);
        livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.OK).body(new LivroResponseDto(livro));
    }
}
