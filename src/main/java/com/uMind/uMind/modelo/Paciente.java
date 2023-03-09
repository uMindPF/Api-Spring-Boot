package com.uMind.uMind.modelo;

import com.uMind.uMind.repositorio.IUsuarioRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente {

    @Autowired
    @Transient
    private IUsuarioRepository usuarioRepository;

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

    public void setFechaInicioDate(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        try {
            this.fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Date getFechaIncioDate() {
        return fechaInicio;
    }

    public String getFechaInicio() {
        if (fechaInicio == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaInicio);
    }

    public void setFechaFinDate(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        try{
            this.fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFechaFinDate() {
        return fechaFin;
    }

    public String getFechaFin() {
        if (fechaFin == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaFin);
    }
}
