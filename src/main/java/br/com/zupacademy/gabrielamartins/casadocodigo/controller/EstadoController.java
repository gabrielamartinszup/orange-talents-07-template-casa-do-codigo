package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.EstadoRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.EstadoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoResponseDto> cadastrar(@RequestBody @Valid EstadoRequestDto estadoRequestDto){
        Estado estado = estadoRequestDto.converteParaEstado(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().body(new EstadoResponseDto(estado));

    }

}
