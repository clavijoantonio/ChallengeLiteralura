package com.clavijoAntonio.challangeLiteralura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clavijoAntonio.challangeLiteralura.model.Libros;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ILibroRepository extends JpaRepository<Libros,Long> {


}
