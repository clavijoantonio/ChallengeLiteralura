package com.clavijoAntonio.challangeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Personas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private int fechaNacimiento;
    private int fechaDefuncion;
    private String nombre;
    @ManyToOne()
    @JoinColumn(name = "libro_id")
    private Libros libro;

    public Personas() {}

    public Personas(DatosPersona dp) {
        this.fechaNacimiento= dp.fechaNacimiento();
        this.fechaDefuncion= dp.fechaDefuncion();
        this.nombre= dp.nombre();

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(int fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "id=" + id +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaDefuncion=" + fechaDefuncion +
                ", nombre='" + nombre  +
                '}';
    }
}
