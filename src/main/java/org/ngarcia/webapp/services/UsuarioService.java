package org.ngarcia.webapp.services;

import jakarta.ejb.Local;
import org.ngarcia.webapp.models.entities.Usuario;

import java.util.*;

@Local
public interface UsuarioService {
   List<Usuario> listar();
   Optional<Usuario> porUsername(String username);
   Optional<Usuario> porId(Long id);
   void guardar(Usuario u);
   void eliminar(Long id);
   Optional<Usuario> login(String username, String password);
}
