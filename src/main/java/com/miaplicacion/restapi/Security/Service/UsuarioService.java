package com.miaplicacion.restapi.Security.Service;
import com.miaplicacion.restapi.Security.Entity.Usuario;
import com.miaplicacion.restapi.Security.Repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
     public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
     
     public void save(Usuario usuario){
         usuarioRepository.save(usuario);
     }
}
