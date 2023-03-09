package com.uMind.uMind.repositorio;

import com.uMind.uMind.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.dni like ?1")
    List<Usuario> findByDniLike(String dni);
}
