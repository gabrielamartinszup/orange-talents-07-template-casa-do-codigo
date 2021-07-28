package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.requestDto.EstadoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Component
public class NomeDeEstadoUnicoPorPais implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return EstadoRequestDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        EstadoRequestDto estadoRequestDto = (EstadoRequestDto) o;
        Query query = manager.createQuery("select e from Estado e where e.nome=:nomeEstado AND e.pais.id=:idPais");
        query.setParameter("nomeEstado", estadoRequestDto.getNome());
        query.setParameter("idPais", estadoRequestDto.getIdPais());
        int quantidadeEstadosAssociadosPaisPorNome = query.getResultList().size();
        if (quantidadeEstadosAssociadosPaisPorNome > 0) {
            errors.rejectValue("nome", null, "Erro! Já existe um estado chamado " + estadoRequestDto.getNome() + " " +
                    "associado ao país com código " + estadoRequestDto.getIdPais());
        }
    }
}
