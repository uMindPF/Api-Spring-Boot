package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "historia_clinica")
@Data
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private Date fecha;

    private String titulo;

    private String descripcion;

    public HistoriaClinica() {
    }

    public void setFechaDate(Date fecha) {
        this.fecha = fecha;
    }

    public void setFecha(String fecha) {
        try {
            this.fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFechaDate() {
        return fecha;
    }

    public String getFecha() {
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
    }
}
