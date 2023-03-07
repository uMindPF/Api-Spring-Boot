package com.uMind.uMind.repositorio;

import com.uMind.uMind.modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

    @Query("select a from Admin a where a.email like concat('%', ?1, '%')")
    List<Admin> findByEmailContaining(@NonNull String email);

    @Query("select a from Admin a where a.login like concat('%', ?1, '%')")
    List<Admin> findByLoginContains(String login);

}
