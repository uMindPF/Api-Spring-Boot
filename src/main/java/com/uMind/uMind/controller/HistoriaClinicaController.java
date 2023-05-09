package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.HistoriaClinica;
import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.servicio.HistoriaClinicaService;
import com.uMind.uMind.servicio.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private PacienteService pacienteService;

    static class ModelHistorial {
        public Integer idPaciente;
        public List<HistoriaClinica> historial;
    }


    @GetMapping("/historial/{id}")
    public String listHistoriasPaciente(@PathVariable Integer id, Model model) {

        ModelHistorial modelHistorial = new ModelHistorial();
        modelHistorial.idPaciente = id;
        modelHistorial.historial = historiaClinicaService.getHistoriaClinicaByPaciente(id);

        model.addAttribute("model", modelHistorial);
        return "historia/historial";
    }

    @GetMapping("/historial/{id}/new")
    public String createHistoriaForm(@PathVariable Integer id, Model model) {

        HistoriaClinica historiaClinica = new HistoriaClinica();
        Paciente paciente = pacienteService.getPacienteById(id);
        historiaClinica.setPaciente(paciente);
        historiaClinica.setFecha(String.valueOf(new java.sql.Date(System.currentTimeMillis())));
        model.addAttribute("historiaClinica", historiaClinica);

        return "historia/create_historia";
    }

    @PostMapping("/historia")
    public String saveHistoria(@ModelAttribute("historiaClinica") HistoriaClinica historiaClinica) {
        historiaClinicaService.saveHistoriaClinica(historiaClinica);
        int idPaciente = historiaClinica.getPaciente().getId();
        return "redirect:/historial/" + idPaciente;
    }

    @GetMapping("/historial/edit/{id}")
    public String editHistoriaForm(@PathVariable Integer id, Model model)
    {
        HistoriaClinica historiaClinica = historiaClinicaService.getHistoriaClinicaById(id);

        model.addAttribute("historiaClinica", historiaClinica);

        return "historia/edit_historia";
    }

    @PostMapping("/historial/update/{id}")
    public String updateHistoria(@PathVariable Integer id, @ModelAttribute("historiaClinica") HistoriaClinica historiaClinica, Model model) {
        HistoriaClinica existingHistoriaClinica = historiaClinicaService.getHistoriaClinicaById(id);

        existingHistoriaClinica.setId(historiaClinica.getId());
        existingHistoriaClinica.setFechaDate(historiaClinica.getFechaDate());
        existingHistoriaClinica.setPaciente(historiaClinica.getPaciente());
        existingHistoriaClinica.setTitulo(historiaClinica.getTitulo());
        existingHistoriaClinica.setDescripcion(historiaClinica.getDescripcion());

        historiaClinicaService.saveHistoriaClinica(existingHistoriaClinica);

        int idPaciente = historiaClinica.getPaciente().getId();

        return "redirect:/historial/" + idPaciente;
    }

    @GetMapping("/historial/delete/{id}")
    public String deleteHistoria(@PathVariable Integer id) {
        HistoriaClinica historiaClinica = historiaClinicaService.getHistoriaClinicaById(id);
        historiaClinicaService.deleteHistoriaClinicaById(id);
        int idPaciente = historiaClinica.getPaciente().getId();
        return "redirect:/historial/" + idPaciente;
    }

}
