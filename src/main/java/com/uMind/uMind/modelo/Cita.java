package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "citas")
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario doctor;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    private Date fecha;

    private String estado;

    @Column(name = "tipo_vista")
    private String tipoVista;

    public Cita() {
    }
}
