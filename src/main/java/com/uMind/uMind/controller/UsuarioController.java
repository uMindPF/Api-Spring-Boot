package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Usuario;
import com.uMind.uMind.security.SecurityClass;
import com.uMind.uMind.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listUsuarios(Model model) {
        model.addAttribute("usuario", usuarioService.getUsuarios());
        return "usuario/usuarios";
    }

    @GetMapping("/usuarios/new")
    public String createUsuarioForm(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);

        return "usuario/create_usuario";
    }

    @PostMapping("/usuarios")
    public String saveUsuario(Usuario usuario) {
        usuario.setPassword(SecurityClass.hashSHA1(usuario.getPassword()));
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/edit/{id}")
    public String editUsuarioForm(@PathVariable Integer id, Model model)
    {
        Usuario usuario = usuarioService.getUsuarioById(id);

        model.addAttribute("usuario", usuario);

        return "usuario/edit_usuario";
    }

    @GetMapping("/usuarios/edit/password/{id}")
    public String editUsuarioPasswordForm(@PathVariable Integer id, Model model)
    {
        Usuario usuario = usuarioService.getUsuarioById(id);

        model.addAttribute("usuario", usuario);

        return "usuario/edit_usuario_password";
    }

    @PostMapping("/usuarios/{id}")
    public String editUsuario(@PathVariable Integer id, Usuario usuario)
    {
        Usuario existingUsuario = usuarioService.getUsuarioById(id);

        existingUsuario.setId(usuario.getId());
        existingUsuario.setDni(usuario.getDni());
        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setApellidos(usuario.getApellidos());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setTelefono(usuario.getTelefono());
        existingUsuario.setLogin(usuario.getLogin());

        usuarioService.saveUsuario(existingUsuario);

        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/password/{id}")
    public String editUsuarioPassword(@PathVariable Integer id, Usuario usuario)
    {
        Usuario existingUsuario = usuarioService.getUsuarioById(id);

        existingUsuario.setPassword(SecurityClass.hashSHA1(usuario.getPassword()));

        usuarioService.saveUsuario(existingUsuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/delete/{id}")
    public String deleteUsuario(@PathVariable Integer id)
    {
        usuarioService.deleteUsuarioById(id);

        return "redirect:/usuarios";
    }
}
