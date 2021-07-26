package br.com.zupacademy.gabrielamartins.casadocodigo.repository;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
