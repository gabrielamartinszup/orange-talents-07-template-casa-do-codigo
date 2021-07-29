package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.ClienteRequestDto;
import br.com.zupacademy.gabrielamartins.casadocodigo.responseDto.ClienteResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Component
public class EstadoPertenceAoPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequestDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {


        ClienteRequestDto clienteRequest = (ClienteRequestDto) o;
        if (clienteRequest.getIdEstado() != null) {
            Estado estado = manager.find(Estado.class, clienteRequest.getIdEstado());
            if (estado.naoPertenceAoPais(clienteRequest.getIdPais())) {
                errors.rejectValue("idEstado", null, "O idEstado não pertence ao país selecionado.");
            }
        }
    }
}
