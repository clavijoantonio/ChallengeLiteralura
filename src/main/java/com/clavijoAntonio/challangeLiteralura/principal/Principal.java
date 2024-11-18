package com.clavijoAntonio.challangeLiteralura.principal;

import java.util.*;

import com.clavijoAntonio.challangeLiteralura.model.DatosApi;
import com.clavijoAntonio.challangeLiteralura.model.DatosLibros;
import com.clavijoAntonio.challangeLiteralura.model.Libros;
import com.clavijoAntonio.challangeLiteralura.repository.ILibroRepository;
import com.clavijoAntonio.challangeLiteralura.service.ConsumoApi;
import com.clavijoAntonio.challangeLiteralura.service.ConvierteDatos;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi= new ConsumoApi();
    private final String URL_BASE="https://gutendex.com/books/?search=dickens%20";
    private ConvierteDatos conversor = new ConvierteDatos();

    private ILibroRepository repository;

    public Principal(ILibroRepository repository){
       this.repository=repository;
    }

    public void menu(){
        int opcion = -1;

        while(opcion!=0){
            var menu= """
                    1. Busca libro por titulo
                    2. Lista libros registrados
                    3. Lista autores registrados
                    4. Lista autores vivos en un  determinado año
                    5. Lista libros por idioma
                    0. salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    buscarLibrosPorTitulo();
                    break;
            }
        }
    }
    public DatosApi getLibrosPorTitulo() {

        System.out.println("Ingresa el libro que desea buscar: ");
        String titulo = teclado.nextLine();
        var json = consumoApi.obtenerJson(URL_BASE+titulo);
        DatosApi datos= conversor.obtenerDatos(json, DatosApi.class);
        return datos;

    }

public void buscarLibrosPorTitulo() {

    DatosLibros li = null;
    DatosApi datos = getLibrosPorTitulo();
    List<DatosLibros> libro = datos.getResults();
    for (DatosLibros libros : libro){
        li=libros;
    };

    Libros lib = new Libros(li);
   repository.save(lib);
  }
}