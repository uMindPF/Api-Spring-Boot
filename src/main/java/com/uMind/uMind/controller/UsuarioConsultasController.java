package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Usuario;
import com.uMind.uMind.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsuarioConsultasController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/consultas/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

}
