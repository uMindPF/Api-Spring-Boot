package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Usuario;
import java.util.List;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    List<Usuario> getUsuarioByNombre(String nombre);

    List<Usuario> getUsuarioByLogin(String email);

    List<Usuario> getUsuarioByDni(String dni);

    Usuario saveUsuario(Usuario usuario);

    Usuario getUsuarioById(Integer id);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuarioById(Integer id);
}
