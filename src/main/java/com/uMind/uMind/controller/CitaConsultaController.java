package com.uMind.uMind.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uMind.uMind.modelo.Cita;
import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.servicio.CitaService;
import lombok.AllArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class CitaConsultaController {

    @Autowired
    ObjectMapper objectMapper;

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

    private static class Data{
        public Integer id;
        public String date;
    }

    @GetMapping("/consultas/citas/{id}/{dateS}")
    public List<Cita> getCitaByDateDoctor(@PathVariable String dateS, @PathVariable Integer id) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);

            System.out.println("Data: " + id + " " + dateS);

            return citaService.getCitaByDateAndDoctor(date, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/consultas/citas/save")
    public void saveCita(@RequestBody String request) {
        try {
            Cita cita = objectMapper.readValue(request, Cita.class);
            System.out.println("Cita: " + cita);

            citaService.saveCita(cita);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
