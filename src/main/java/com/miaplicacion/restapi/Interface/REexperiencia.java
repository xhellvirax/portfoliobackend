package com.miaplicacion.restapi.Interface;
import com.miaplicacion.restapi.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface REexperiencia extends JpaRepository <Experiencia, Integer> {
    public Optional<Experiencia> findByNombreA (String nombreA);
    public boolean existsByNombreA(String nombreA);
}
