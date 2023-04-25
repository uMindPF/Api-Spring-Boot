package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Cita;
import com.uMind.uMind.servicio.CitaService;
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
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/citas")
    public String listCitas(Model model) {
        model.addAttribute("cita", citaService.getCitas());
        return "cita/citas";
    }

    @GetMapping("/citas/new")
    public String createCitaForm(Model model) {
        Cita cita = new Cita();

        model.addAttribute("cita", cita);

        return "cita/create_cita";
    }

    @PostMapping("/citas")
    public String saveCita(@ModelAttribute("cita") Cita cita) {
        citaService.saveCita(cita);
        return "redirect:/citas";
    }

    @GetMapping("/citas/edit/{id}")
    public String editCitaForm(@PathVariable Integer id, Model model)
    {
        Cita cita = citaService.getCitaById(id);

        model.addAttribute("cita", cita);

        return "cita/edit_cita";
    }

    @PostMapping("/citas/{id}")
    public String updateCita(@PathVariable Integer id, @ModelAttribute("cita") Cita cita, Model model) {
        Cita existingCita = citaService.getCitaById(id);

        existingCita.setId(cita.getId());
        existingCita.setDoctor(cita.getDoctor());
        existingCita.setPaciente(cita.getPaciente());
        existingCita.setFechaDate(cita.getFechaDate());
        existingCita.setEstado(cita.getEstado());
        existingCita.setTipoVista(cita.getTipoVista());
        existingCita.setHora(cita.getHora());
        existingCita.setDuracion(cita.getDuracion());

        citaService.saveCita(existingCita); 

        return "redirect:/citas";
    }

    @GetMapping("/citas/delete/{id}")
    public String deleteCita(@PathVariable Integer id) {
        citaService.deleteCitaById(id);
        return "redirect:/citas";
    }
}
