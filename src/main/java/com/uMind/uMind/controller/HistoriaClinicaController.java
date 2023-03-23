package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.HistoriaClinica;
import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.servicio.HistoriaClinicaService;
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
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping("/historias")
    public String listHistorias(Model model) {
        model.addAttribute("historia", historiaClinicaService.getHistoriasClinicas());
        return "historia/historias";
    }

    @GetMapping("/historias/new")
    public String createHistoriaForm(Model model) {
        HistoriaClinica historiaClinica = new HistoriaClinica();

        model.addAttribute("historiaClinica", historiaClinica);

        return "historia/create_historia";
    }

    @PostMapping("/historias")
    public String saveHistoria(@ModelAttribute("historiaClinica") HistoriaClinica historiaClinica) {
        historiaClinicaService.saveHistoriaClinica(historiaClinica);
        return "redirect:/historias";
    }

    @GetMapping("/historias/edit/{id}")
    public String editHistoriaForm(@PathVariable Integer id, Model model)
    {
        HistoriaClinica historiaClinica = historiaClinicaService.getHistoriaClinicaById(id);

        model.addAttribute("historiaClinica", historiaClinica);

        return "historia/edit_historia";
    }

    @PostMapping("/historias/{id}")
    public String updateHistoria(@PathVariable Integer id, @ModelAttribute("historiaClinica") HistoriaClinica historiaClinica, Model model) {
        HistoriaClinica existingHistoriaClinica = historiaClinicaService.getHistoriaClinicaById(id);

        existingHistoriaClinica.setId(historiaClinica.getId());
        existingHistoriaClinica.setFechaDate(historiaClinica.getFechaDate());
        existingHistoriaClinica.setPaciente(historiaClinica.getPaciente());
        existingHistoriaClinica.setTitulo(historiaClinica.getTitulo());
        existingHistoriaClinica.setDescripcion(historiaClinica.getDescripcion());

        historiaClinicaService.saveHistoriaClinica(existingHistoriaClinica);

        return "redirect:/historias";
    }

    @GetMapping("/historias/delete/{id}")
    public String deleteHistoria(@PathVariable Integer id) {
        historiaClinicaService.deleteHistoriaClinicaById(id);
        return "redirect:/historias";
    }

}
