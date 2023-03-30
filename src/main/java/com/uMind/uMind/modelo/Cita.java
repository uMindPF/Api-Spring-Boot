package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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

    private Date dia;

    private LocalTime hora;

    private double duracion;

    private String estado;

    @Column(name = "tipo_vista")
    private String tipoVista;

    public Cita() {
    }

    public void setDia(String dia) {
        try {
            this.dia = new SimpleDateFormat("yyyy-MM-dd").parse(dia);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFechaDate(Date fecha) {
        this.dia = fecha;
    }

    public String getDia() {
        if (dia == null) return null;

        return new SimpleDateFormat("yyyy-MM-dd").format(dia);
    }

    public Date getFechaDate() {
        return dia;
    }

    public void setHora(String hora) {
        try {
            this.hora = LocalTime.parse(hora);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setHoraDate(Date hora) {
        this.hora = hora.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();
    }

    public Date getHoraDate() {
        return java.sql.Time.valueOf(hora);
    }

    public String getHora() {
        if (hora == null) return null;

        return hora.toString();
    }


}
