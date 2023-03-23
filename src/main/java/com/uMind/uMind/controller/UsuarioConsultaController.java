package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Usuario;
import com.uMind.uMind.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsuarioConsultaController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/consultas/usuarios")
    private List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/consultas/usuarios/{id}")
    private Usuario getUsuarioById(Integer id) {
        return usuarioService.getUsuarioById(id);
    }

}
