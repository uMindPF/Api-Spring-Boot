package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Paciente;
import java.util.List;

public interface IPacienteService {

    List<Paciente> getPacientes();

    List<Paciente> getPacienteByNombre(String nombre);

    Paciente savePaciente(Paciente paciente);

    Paciente getPacienteById(Integer id);

    Paciente updatePaciente(Paciente paciente);

    void deletePacienteById(Integer id);
}
