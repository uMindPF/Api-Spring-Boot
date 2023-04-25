package com.uMind.uMind.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uMind.uMind.modelo.Cita;
import com.uMind.uMind.modelo.HistoriaClinica;
import com.uMind.uMind.servicio.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class HistoriaClinicaConsultasController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping("/consultas/historial/{id}")
    public HistoriaClinica getHistoria(@PathVariable Integer id){
        return historiaClinicaService.getHistoriaClinicaById(id);
    }

    @GetMapping("/consultas/historial/paciente/{id}")
    public List<HistoriaClinica> getHistorial(@PathVariable Integer id){
        return historiaClinicaService.getHistoriaClinicaByPaciente(id);
    }


    private static class Data{
        public Integer id;
        public String date;
    }

    @PostMapping("/consultas/historial/datePaciente")
    public List<HistoriaClinica> getCitaByDateDoctor(@RequestBody String request) {
        try {
            Data data = objectMapper.readValue(request, Data.class);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data.date);

            return historiaClinicaService.getHistoriaClinicaByPacienteAndDate(data.id, date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/consultas/historial/save")
    public void saveCita(@RequestBody String request) {
        try {
            HistoriaClinica historiaClinica = objectMapper.readValue(request, HistoriaClinica.class);
            System.out.println("HistoriaClinica: " + historiaClinica);

            historiaClinicaService.saveHistoriaClinica(historiaClinica);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
