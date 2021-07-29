package br.com.zupacademy.gabrielamartins.casadocodigo.repository;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
