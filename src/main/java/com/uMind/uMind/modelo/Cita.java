package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void setFecha(String fecha) {
        try {
            this.fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFechaDate(Date fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        if (fecha == null) return null;

        return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
    }

    public Date getFechaDate() {
        return fecha;
    }
}
