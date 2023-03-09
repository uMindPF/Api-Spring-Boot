package com.uMind.uMind.modelo;

import com.uMind.uMind.security.SecurityClass;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    private String apellidos;

    @Column(name = "correo", nullable = false)
    private String email;

    private String telefono;

    private String login;

    private String password;

    public Usuario() {
    }

    public Usuario(int id, String dni, String nombre, String apellidos, String email, String telefono, String login, String password) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.login = login;
        this.password = SecurityClass.hashSHA1(password);
    }
}
