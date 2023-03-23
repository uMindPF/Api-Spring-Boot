package com.uMind.uMind.security.token;

import com.uMind.uMind.modelo.Admin;
import com.uMind.uMind.modelo.Usuario;
import com.uMind.uMind.repositorio.IAdminRepository;
import com.uMind.uMind.repositorio.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("username: " + username);
        List<Admin> admins = adminRepository.findByLoginLike(username);
        List<Usuario> usuarios = usuarioRepository.findByLoginLike(username);

        if (admins.size() > 0) {
            Admin admin = admins.get(0);
            Usuario usuarioAdmin = new Usuario();
            usuarioAdmin.setLogin(admin.getLogin());
            usuarioAdmin.setPassword(admin.getPassword());
            usuarioAdmin.setNombre("ADMIN");
            return new UserDetailsImpl(usuarioAdmin);
        } else if (usuarios.size() > 0) {
            Usuario usuario = usuarios.get(0);
            return new UserDetailsImpl(usuario);
        } else {
            return null;
        }
    }
}
