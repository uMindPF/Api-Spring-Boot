package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Usuario;
import org.springframework.stereotype.Service;
import com.uMind.uMind.repositorio.IUsuarioRepository;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getUsuarioByNombre(String nombre) {
        return null;
    }

    @Override
    public List<Usuario> getUsuarioByLogin(String email) {
        return null;
    }

    @Override
    public List<Usuario> getUsuarioByDni(String dni) {
        return usuarioRepository.findByDniLike(dni);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
