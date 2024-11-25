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
    @Column(unique = true)
    private String titulo;
    //private List<String> subjectos;
    @OneToMany(mappedBy = "libro",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Personas> autores;
    @Enumerated(EnumType.STRING)
    private Idiomas idioma;
    private String editorial;
    private int descargas;

    public Libros(){}



    public Libros(DatosLibros libros) {
        this.titulo = libros.titulo();
        this.editorial = libros.editorial();
        this.descargas = libros.descargas();
        this.idioma=Idiomas.fromString(libros.idioma());

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

    public List<Personas> getAutores() {
        return autores;
    }
    public void setAutores(List<Personas> autores) {
        autores.forEach(a-> a.setLibro(this));
        this.autores = autores;
    }

    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", editorial='" + editorial + '\'' +
                ", descargas=" + descargas;

    }


}
