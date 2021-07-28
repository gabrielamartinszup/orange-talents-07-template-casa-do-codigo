package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.NomeDeEstadoUnicoPorPais;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.EstadoRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.EstadoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private NomeDeEstadoUnicoPorPais nomeDeEstadoUnicoPorPais;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(nomeDeEstadoUnicoPorPais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoResponseDto> cadastrar(@RequestBody @Valid EstadoRequestDto estadoRequestDto){
        Estado estado = estadoRequestDto.converteParaEstado(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().body(new EstadoResponseDto(estado));

    }

}
