package com.uMind.uMind.repositorio;

import com.uMind.uMind.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query("select p from Paciente p where p.nombre like concat('%', ?1, '%') or p.apellidos like concat('%', ?2, '%')")
    List<Paciente> findByNombreContainsOrApellidosContains(String nombre, String apellidos);
}
