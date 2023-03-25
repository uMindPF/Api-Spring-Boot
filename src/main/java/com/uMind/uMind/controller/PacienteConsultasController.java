package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.servicio.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PacienteConsultasController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/consultas/pacientes")
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }
}
