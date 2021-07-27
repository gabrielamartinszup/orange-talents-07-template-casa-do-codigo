package br.com.zupacademy.gabrielamartins.casadocodigo.repository;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
