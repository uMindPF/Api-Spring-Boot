package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.servicio.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/pacientes")
    public String listPacientes(Model model) {
        model.addAttribute("paciente", pacienteService.getPacientes());
        return "paciente/pacientes";
    }

    @GetMapping("/pacientes/new")
    public String createPacienteForm(Model model) {
        Paciente paciente = new Paciente();

        model.addAttribute("paciente", paciente);

        return "paciente/create_paciente";
    }

    @PostMapping("/pacientes")
    public String savePaciente(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/edit/{id}")
    public String editPacienteForm(@PathVariable Integer id, Model model)
    {
        Paciente paciente = pacienteService.getPacienteById(id);

        model.addAttribute("paciente", paciente);

        return "paciente/edit_paciente";
    }

    @PostMapping("/pacientes/{id}")
    public String updatePaciente(@PathVariable Integer id, @ModelAttribute("paciente") Paciente paciente, Model model) {
        Paciente existingPaciente = pacienteService.getPacienteById(id);

        existingPaciente.setId(paciente.getId());
        existingPaciente.setDni(paciente.getDni());
        existingPaciente.setNombre(paciente.getNombre());
        existingPaciente.setApellidos(paciente.getApellidos());
        existingPaciente.setEmail(paciente.getEmail());
        existingPaciente.setTelefono(paciente.getTelefono());
        existingPaciente.setSexo(paciente.getSexo());
        existingPaciente.setFechaInicio(paciente.getFechaInicio());
        existingPaciente.setFechaFin(paciente.getFechaFin());
        existingPaciente.setPoblacion(paciente.getPoblacion());
        existingPaciente.setAntecedentesMedicos(paciente.getAntecedentesMedicos());
        existingPaciente.setDoctor(paciente.getDoctor());

        pacienteService.savePaciente(existingPaciente);

        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/delete/{id}")
    public String deletePaciente(@PathVariable Integer id) {
        pacienteService.deletePacienteById(id);
        return "redirect:/pacientes";
    }
}
