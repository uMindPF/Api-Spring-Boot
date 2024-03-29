package com.uMind.uMind.repositorio;

import com.uMind.uMind.modelo.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IHistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {
    @Query("select h from HistoriaClinica h where h.paciente.id = ?1")
    List<HistoriaClinica> findByPaciente_Id(int id);

    @Query("select h from HistoriaClinica h where h.paciente.id = ?1 and h.fecha = ?2")
    List<HistoriaClinica> findByPaciente_IdAndFecha(int id, Date fecha);


}
