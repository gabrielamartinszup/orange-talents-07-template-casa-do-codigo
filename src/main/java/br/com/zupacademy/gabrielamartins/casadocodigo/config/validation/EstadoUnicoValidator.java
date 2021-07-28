package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.EstadoRequestDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EstadoUnicoValidator implements ConstraintValidator<EstadoUnico, Object> {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from Estado e join e.pais p where e.nome =:nome and p.id =:idpais");

        EstadoRequestDto estadoRequest = (EstadoRequestDto) o;
        query.setParameter("nome", estadoRequest.getNome());
        query.setParameter("idpais", estadoRequest.getIdPais());

        Optional<?> result = query.getResultList().stream().findFirst();

        return result.isEmpty();
    }
}
