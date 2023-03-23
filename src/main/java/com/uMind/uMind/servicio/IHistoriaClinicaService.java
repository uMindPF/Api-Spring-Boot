package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.HistoriaClinica;

import java.util.List;

public interface IHistoriaClinicaService {

    List<HistoriaClinica> getHistoriasClinicas();

    List<HistoriaClinica> getHistoriaClinicaByPaciente(Integer paciente);

    HistoriaClinica saveHistoriaClinica(HistoriaClinica historiaClinica);

    HistoriaClinica getHistoriaClinicaById(Integer id);

    HistoriaClinica updateHistoriaClinica(HistoriaClinica historiaClinica);

    void deleteHistoriaClinicaById(Integer id);
}
