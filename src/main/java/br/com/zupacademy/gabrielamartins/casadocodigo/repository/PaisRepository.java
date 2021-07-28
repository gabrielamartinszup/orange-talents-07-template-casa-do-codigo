package br.com.zupacademy.gabrielamartins.casadocodigo.repository;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
