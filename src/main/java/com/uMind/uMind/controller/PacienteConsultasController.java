package com.uMind.uMind.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.modelo.Usuario;
import com.uMind.uMind.servicio.PacienteService;
import com.uMind.uMind.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class PacienteConsultasController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/consultas/pacientes")
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

    @GetMapping("/consultas/pacientes/{id}")
    public Paciente getPacienteById(@PathVariable Integer id) {
        return pacienteService.getPacienteById(id);
    }

    @GetMapping("/consultas/pacientes/nombre/{nombre}")
    public List<Paciente> getPacienteByNombre(@PathVariable String nombre) {
        return pacienteService.getPacienteByNombre(nombre);
    }

    @PostMapping("/consultas/pacientes/save")
    public void savePaciente(@RequestBody String request) {
        try {
            Paciente paciente = objectMapper.readValue(request, Paciente.class);
            paciente.setDoctor(usuarioService.getUsuarioById(paciente.getDoctor().getId()));
            System.out.println("Paciente: " + paciente);

            pacienteService.savePaciente(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
