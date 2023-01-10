package com.miaplicacion.restapi.Service;
import com.miaplicacion.restapi.Entity.Experiencia;
import com.miaplicacion.restapi.Interface.REexperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SExperiencia {
    @Autowired
    REexperiencia reExperiencia;
    public List <Experiencia> list() {
        return reExperiencia.findAll();
    }
    
    public Optional <Experiencia> getOne (int id) {
        return reExperiencia.findById(id);
    }
    
    public Optional <Experiencia> getByNombreA (String nombreA) {
        return reExperiencia.findByNombreA(nombreA);
    }
    
    public void save (Experiencia expe) {
        reExperiencia.save(expe);
    }
    
    public void delete (int id) {
        reExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return reExperiencia.existsById(id);
    }
    
    public boolean existsByNombreA(String nombreA) {
        return reExperiencia.existsByNombreA(nombreA);
    }
}
