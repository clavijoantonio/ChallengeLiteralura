package com.clavijoAntonio.challangeLiteralura.repository;

import com.clavijoAntonio.challangeLiteralura.model.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clavijoAntonio.challangeLiteralura.model.Libros;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ILibroRepository extends JpaRepository<Libros,Long> {


public List<Libros> findByIdioma(Idiomas idioma);
}
