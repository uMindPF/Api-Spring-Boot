package com.uMind.uMind.repositorio;

import com.uMind.uMind.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepostory extends JpaRepository<Cita, Integer> {
}
