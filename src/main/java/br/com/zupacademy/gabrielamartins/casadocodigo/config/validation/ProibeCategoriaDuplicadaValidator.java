package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Categoria;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.CategoriaRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequestDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaRequestDto requestDto = (CategoriaRequestDto) o;
        Optional<Categoria> categoria = categoriaRepository.findByNome(requestDto.getNome());

        if(categoria.isPresent()){
            errors.rejectValue("nome", "CategoriaUnica");

        }


    }
}
