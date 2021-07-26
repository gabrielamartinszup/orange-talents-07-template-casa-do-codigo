package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.ProibeCategoriaDuplicadaValidator;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.CategoriaRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.CategoriaResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProibeCategoriaDuplicadaValidator proibeCategoriaDuplicadaValidator;

    @InitBinder
    public void init(WebDataBinder binder){

        binder.addValidators(proibeCategoriaDuplicadaValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponseDto> cadastrarCategoria(@Valid @RequestBody CategoriaRequestDto requestDto){

        Categoria categoria = requestDto.converteParaCategoria();
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(new CategoriaResponseDto(categoria));
    }
}
