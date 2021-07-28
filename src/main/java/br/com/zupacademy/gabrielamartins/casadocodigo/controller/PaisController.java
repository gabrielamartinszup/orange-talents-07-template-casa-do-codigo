package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.PaisRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.PaisResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisResponseDto> cadastrarPais(@Valid @RequestBody PaisRequestDto requestDto){

        Pais pais = requestDto.converteParaPais();
        paisRepository.save(pais);

        return ResponseEntity.ok().body(new PaisResponseDto(pais));
    }
}
