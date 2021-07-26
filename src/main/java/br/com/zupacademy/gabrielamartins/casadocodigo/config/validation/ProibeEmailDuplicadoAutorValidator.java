package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.AutorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;


    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequestDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorRequestDto requestDto = (AutorRequestDto) o;
        Optional<Autor> autor = autorRepository.findByEmail(requestDto.getEmail());

        if(autor.isPresent()){
            errors.rejectValue("email", "EmailUnico",  requestDto.getEmail());

        }

    }
}
