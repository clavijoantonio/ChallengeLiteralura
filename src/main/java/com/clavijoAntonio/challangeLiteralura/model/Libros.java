package com.clavijoAntonio.challangeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name="libros")
public class Libros {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String titulo;
    //private List<String> subjetos;
    //private List<DatosPersona> autores;
    //private List<DatosPersona> traductores;
   // private List<String> estanteria;
   // private List<String> idioma;
    private String editorial;
    private int descargas;

    public Libros(){}



    public Libros(DatosLibros libros) {
        this.titulo = libros.titulo();
        this.editorial = libros.editorial();
        this.descargas = libros.descargas();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", descargas=" + descargas +
                '}';
    }
}
