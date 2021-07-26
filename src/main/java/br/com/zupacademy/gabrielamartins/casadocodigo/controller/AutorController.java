package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.AutorRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.AutorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponseDto> cadastrarAutor(@RequestBody @Valid AutorRequestDto requestDto){

        Autor autor = requestDto.converteParaAutor();
        autorRepository.save(autor);
      return ResponseEntity.status(HttpStatus.OK).body(new AutorResponseDto(autor));
    }
}
