package br.com.zupacademy.gabrielamartins.casadocodigo.repository;

import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {


    @Query(value="SELECT count(1) FROM estado WHERE pais_id = :paisId", nativeQuery = true)
    Long contaEstadoPorPais(Long paisId);
}
