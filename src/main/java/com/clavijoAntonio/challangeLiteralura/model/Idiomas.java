package com.clavijoAntonio.challangeLiteralura.model;

import java.util.List;
import java.util.Optional;

public enum Idiomas {
    INGLES("en"),
    ESPAÑOL("es"),
    FRANCES("fr"),
    ALEMAN("al");


    private String idiomaBase;

    Idiomas(String idiomaBase) {
        this.idiomaBase = idiomaBase;
    }


    public static Idiomas fromString(List<String> text) {
        for (Idiomas idioma : Idiomas.values()) {
            if (idioma.idiomaBase.equalsIgnoreCase(text.get(0))) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
