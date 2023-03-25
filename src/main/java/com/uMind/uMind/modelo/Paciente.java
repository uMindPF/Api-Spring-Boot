package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    private String apellidos;

    @Column(name = "correo", nullable = false)
    private String email;

    private String telefono;

    private String sexo;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    private Date fechaBaja;

    private String poblacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Usuario doctor;

    public Paciente() {
    }

    public void setFechaInicioDate(Date fechaInicio) {
        this.fechaAlta = fechaInicio;
    }

    public void setFechaAlta(String fechaAlta) {
        try {
            this.fechaAlta = new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Date getFechaIncioDate() {
        return fechaAlta;
    }

    public String getFechaAlta() {
        if (fechaAlta == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaAlta);
    }

    public void setFechaFinDate(Date fechaFin) {
        this.fechaBaja = fechaFin;
    }

    public void setFechaBaja(String fechaBaja) {
        try{
            this.fechaBaja = new SimpleDateFormat("yyyy-MM-dd").parse(fechaBaja);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFechaFinDate() {
        return fechaBaja;
    }

    public String getFechaBaja() {
        if (fechaBaja == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaBaja);
    }

    public void setFechaNacimientoDate(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        try {
            this.fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFechaNacimientoDate() {
        return fechaNacimiento;
    }

    public String getFechaNacimiento() {
        if (fechaNacimiento == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaNacimiento);
    }
}
