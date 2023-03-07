package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Cita;
import com.uMind.uMind.repositorio.ICitaRepostory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService implements ICitaService {

    private ICitaRepostory citaRepostory;

    public CitaService(ICitaRepostory citaRepostory) {
        this.citaRepostory = citaRepostory;
    }

    @Override
    public List<Cita> getCitas() {
        return citaRepostory.findAll();
    }

    @Override
    public List<Cita> getCitaByPaciente(String paciente) {
        return null;
    }

    @Override
    public List<Cita> getCitaByDoctor(String doctor) {
        return null;
    }

    @Override
    public Cita saveCita(Cita cita) {
        return citaRepostory.save(cita);
    }

    @Override
    public Cita getCitaById(Integer id) {
        return citaRepostory.findById(id).get();
    }

    @Override
    public Cita updateCita(Cita cita) {
        return citaRepostory.save(cita);
    }

    @Override
    public void deleteCitaById(Integer id) {
        citaRepostory.deleteById(id);
    }
}
