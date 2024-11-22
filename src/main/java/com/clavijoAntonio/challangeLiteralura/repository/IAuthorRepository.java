package com.clavijoAntonio.challangeLiteralura.repository;

import com.clavijoAntonio.challangeLiteralura.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Personas,Long> {
}
