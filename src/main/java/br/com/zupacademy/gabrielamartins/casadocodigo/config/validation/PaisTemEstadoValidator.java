package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.ClienteRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Positive;

@Component
public class PaisTemEstadoValidator implements Validator {


    @PersistenceContext
    private EntityManager manager;



    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequestDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }
        ClienteRequestDto clienteRequest = (ClienteRequestDto) o;
        Pais pais = manager.find(Pais.class, clienteRequest.getIdPais());

        if (pais.paisPossuiEstados() && clienteRequest.getIdEstado() == null) {
            errors.rejectValue("idEstado", null, "Estado Inválido!! Este país possuí estados cadastrados");
            return;
        }
    }
}
