package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente {
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

    private String sexo;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    private String poblacion;

    @Column(name = "antecedentes_medicos")
    private String antecedentesMedicos;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Usuario doctor;

    public Paciente() {
    }
}
