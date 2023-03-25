package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Cita;
import com.uMind.uMind.servicio.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class CitaConsultaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/consultas/citas")
    public List<Cita> getCitas() {
        return citaService.getCitas();
    }

    @GetMapping("/consultas/citas/{id}")
    public Cita getCitaById(@PathVariable Integer id) {
        return citaService.getCitaById(id);
    }

    @GetMapping("/consultas/citas/paciente/{id}")
    public List<Cita> getCitaByPaciente(@PathVariable Integer id) {
        return citaService.getCitaByPaciente(id);
    }

    @GetMapping("/consultas/citas/doctor/{id}")
    public List<Cita> getCitaByDoctor(@PathVariable Integer id) {
        return citaService.getCitaByDoctor(id);
    }

    @GetMapping("/consultas/citas/date/{dateS}")
    public List<Cita> getCitaByDate(@PathVariable String dateS) {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dateS);
            return citaService.getCitaByDate(date);
        } catch (Exception e) {
            return null;
        }
    }
}