package model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class DatosPersona {
    @JsonAlias("birth_year") int fechaNacimiento;
    @JsonAlias("death_year")int fechaDefuncion;
    @JsonAlias("name")String nombre;
}
