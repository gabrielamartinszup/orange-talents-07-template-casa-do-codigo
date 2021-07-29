package br.com.zupacademy.gabrielamartins.casadocodigo.controller;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.EstadoPertenceAoPaisValidator;
import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.PaisTemEstadoValidator;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Cliente;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.ClienteRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.ClienteResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;


    @Autowired
    EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;

    @Autowired
    PaisTemEstadoValidator paisTemEstadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {

        binder.addValidators(estadoPertenceAoPaisValidator, paisTemEstadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponseDto> cadastrarCliente(@Valid @RequestBody ClienteRequestDto clienteRequestDto){

        Cliente cliente = clienteRequestDto.converteParaCliente(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.ok().body(new ClienteResponseDto(cliente));

    }
}
