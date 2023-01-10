package com.miaplicacion.restapi.Security.Repository;
import com.miaplicacion.restapi.Security.Entity.Rol;
import com.miaplicacion.restapi.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
