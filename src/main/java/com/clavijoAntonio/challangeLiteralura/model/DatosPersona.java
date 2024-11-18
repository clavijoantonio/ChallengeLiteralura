package com.clavijoAntonio.challangeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosPersona (
    @JsonAlias("birth_year") int fechaNacimiento,
    @JsonAlias("death_year")int fechaDefuncion,
    @JsonAlias("name")String nombre ){
}
