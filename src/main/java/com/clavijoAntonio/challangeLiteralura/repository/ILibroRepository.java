package com.clavijoAntonio.challangeLiteralura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clavijoAntonio.challangeLiteralura.model.Libros;

public interface ILibroRepository extends JpaRepository<Libros,Long> {
}
