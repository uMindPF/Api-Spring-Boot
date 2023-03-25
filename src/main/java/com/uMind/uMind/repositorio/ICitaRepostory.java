package com.uMind.uMind.repositorio;

import com.uMind.uMind.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICitaRepostory extends JpaRepository<Cita, Integer> {
    @Query("select c from Cita c where c.doctor.id = ?1")
    List<Cita> findByDoctor_Id(int id);

    @Query("select c from Cita c where c.dia = ?1")
    List<Cita> findByDia(Date dia);
}
