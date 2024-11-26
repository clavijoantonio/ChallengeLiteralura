package com.clavijoAntonio.challangeLiteralura.repository;

import com.clavijoAntonio.challangeLiteralura.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAuthorRepository extends JpaRepository<Personas,Long> {
@Query(value = "SELECT * FROM personas WHERE fecha_nacimiento>=?1",nativeQuery = true)
public List<Personas> findAllbyAño(String año);
}
