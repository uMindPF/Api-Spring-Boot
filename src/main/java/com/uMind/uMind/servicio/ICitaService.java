package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Cita;

import java.util.List;

public interface ICitaService {

    List<Cita> getCitas();

    List<Cita> getCitaByPaciente(String paciente);

    List<Cita> getCitaByDoctor(String doctor);

    Cita saveCita(Cita cita);

    Cita getCitaById(Integer id);

    Cita updateCita(Cita cita);

    void deleteCitaById(Integer id);
}
