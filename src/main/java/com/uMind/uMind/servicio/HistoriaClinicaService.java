package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.HistoriaClinica;
import com.uMind.uMind.repositorio.IHistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoriaClinicaService implements IHistoriaClinicaService {
    
    @Autowired
    private IHistoriaClinicaRepository historiaClinicaRepository;
    
    @Override
    public List<HistoriaClinica> getHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public List<HistoriaClinica> getHistoriaClinicaByPaciente(Integer paciente) {
        return historiaClinicaRepository.findByPaciente_Id(paciente);
    }

    @Override
    public HistoriaClinica saveHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public HistoriaClinica getHistoriaClinicaById(Integer id) {
        return historiaClinicaRepository.findById(id).get();
    }

    public List<HistoriaClinica> getHistoriaClinicaByPacienteAndDate(Integer id, Date date) {
        return historiaClinicaRepository.findByPaciente_IdAndFecha(id, date);
    }

    @Override
    public HistoriaClinica updateHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public void deleteHistoriaClinicaById(Integer id) {
        historiaClinicaRepository.deleteById(id);
    }
}
