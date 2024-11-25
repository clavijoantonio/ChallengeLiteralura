package com.clavijoAntonio.challangeLiteralura.service;

import com.clavijoAntonio.challangeLiteralura.model.Idiomas;
import com.clavijoAntonio.challangeLiteralura.model.Libros;
import com.clavijoAntonio.challangeLiteralura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibrosService {

    @Autowired
    private ILibroRepository repository;

    public List<Libros> findLibroByIdioma(String idioma) {
        Idiomas idiomaEnum;
        try {
            idiomaEnum = Idiomas.valueOf(idioma.toUpperCase());
        }
        catch (IllegalArgumentException e) { throw new RuntimeException("Idioma no válido: " + idioma);
        }
        return repository.findByIdioma(idiomaEnum); }
}
