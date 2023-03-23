package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Paciente;
import com.uMind.uMind.repositorio.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    private IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public List<Paciente> getPacienteByDoctor(Integer doctorId) {
        return null;
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente getPacienteById(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePacienteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
