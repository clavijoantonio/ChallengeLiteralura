package com.clavijoAntonio.challangeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(

        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosPersona> autores,
        @JsonAlias("translators") List<DatosPersona> traductores,
        @JsonAlias("languages") List<String>  idioma,
        @JsonAlias("media_type") String editorial,
        @JsonAlias("download_count") int descargas
) {
}
