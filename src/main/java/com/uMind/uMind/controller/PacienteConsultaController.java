package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.servicio.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PacienteConsultaController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/consultas/pacientes")
    private List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

    @PostMapping("/consultas/pacientes/{id}")
    private Paciente getPacienteById(Integer id) {
        return pacienteService.getPacienteById(id);
    }

    @PostMapping("/consultas/pacientes/doctor/{id}")
    private List<Paciente> getPacientesByDoctor(Integer id) {
        return pacienteService.getPacienteByDoctor(id);
    }


}
