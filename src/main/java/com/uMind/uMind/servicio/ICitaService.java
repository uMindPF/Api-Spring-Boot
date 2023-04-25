package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Cita;

import java.util.Date;
import java.util.List;

public interface ICitaService {

    List<Cita> getCitas();

    List<Cita> getCitaByPaciente(Integer paciente);

    List<Cita> getCitaByDoctor(Integer doctor);

    List<Cita> getCitaByDate(Date date);

    List<Cita> getCitaByDateAndDoctor(Date date, Integer doctor);

    Cita saveCita(Cita cita);

    Cita getCitaById(Integer id);

    Cita updateCita(Cita cita);

    void deleteCitaById(Integer id);
}
