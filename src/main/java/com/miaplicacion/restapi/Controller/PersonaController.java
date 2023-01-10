package com.miaplicacion.restapi.Controller;
import com.miaplicacion.restapi.Dto.dtoPersona;
import com.miaplicacion.restapi.Entity.Persona;
import com.miaplicacion.restapi.Security.Controller.Mensaje;
import com.miaplicacion.restapi.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    ImpPersonaService Personaservice;
    
    @GetMapping("/personas/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = Personaservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (Personaservice.existsByNombre(dtopersona.getNombre())) 
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
          Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getDescripcion());
          Personaservice.save(persona);
          return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);                
    }*/
    @PutMapping("/personas/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoPersona dtopersona) {
        //Validamos si existe el ID
        if(!Personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencia
        if(Personaservice.existsByNombre(dtopersona.getNombre()) && Personaservice.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        // El campo no puede estar vacio
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        
        Persona persona = Personaservice.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        Personaservice.save(persona);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/personas/delete/{id}")
     public ResponseEntity<?> delete (@PathVariable("id") int id) {
         //Validamos si existe el ID
            if(!Personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
            Personaservice.delete(id);
            return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
        }
     @GetMapping("/personas/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!Personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        Persona persona = Personaservice.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    }
    

