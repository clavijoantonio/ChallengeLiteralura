package com.clavijoAntonio.challangeLiteralura.principal;

import java.util.*;
import java.util.stream.Collectors;

import com.clavijoAntonio.challangeLiteralura.model.*;

import com.clavijoAntonio.challangeLiteralura.repository.IAuthorRepository;
import com.clavijoAntonio.challangeLiteralura.repository.ILibroRepository;
import com.clavijoAntonio.challangeLiteralura.service.ConsumoApi;
import com.clavijoAntonio.challangeLiteralura.service.ConvierteDatos;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi= new ConsumoApi();
    private final String URL_BASE="https://gutendex.com/books/?search=dickens%20";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibros> dlibro;
    private ILibroRepository repository;
    private IAuthorRepository autorRepository;
    private List<Libros> libroRegistrado;

    public Principal(ILibroRepository repository, IAuthorRepository autorRepository){

        this.repository=repository;
        this.autorRepository=autorRepository;
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
                    case 2:
                        listarLibrosRegistados();
                        break;
                        case 3:
                            listarAutoresRegistados();
                        break;
            }
        }
    }
    public DatoApi getLibrosPorTitulo() {

        System.out.println("Ingresa el libro que desea buscar: ");
        String titulo = teclado.nextLine();
        var json = consumoApi.obtenerJson(URL_BASE+titulo.replace(" ","+"));
        DatoApi datos= conversor.obtenerDatos(json, DatoApi.class);
        //System.out.println(json);
        return datos;

    }

public void buscarLibrosPorTitulo() {

    DatosLibros li = null;

    List <DatoApi>api = new ArrayList<>();
    api.add(getLibrosPorTitulo());

    Optional<DatoApi> lib= api.stream()
            .findFirst();

    if (lib.isPresent()) {

        dlibro = api.stream()
                .flatMap(a -> a.results().stream())
                .collect(Collectors.toList());


        List<Libros> libro = dlibro.stream()
                .map(dl -> new Libros(dl))
                .collect(Collectors.toList());

    }
    for (DatosLibros libros : dlibro) {
        li = libros;
        System.out.println(libros);
    }

    Libros libros= new Libros(li);
    repository.save(libros);

  }

  public void listarLibrosRegistados(){

        libroRegistrado = repository.findAll();
        libroRegistrado.forEach(System.out::println);

  }
public void listarAutoresRegistados(){
    registarAuthores();
    List<Personas> autor = new ArrayList<>();
    autor = autorRepository.findAll();
    autor.forEach(System.out::println);
}
  public void registarAuthores(){

        listarLibrosRegistados();

      System.out.println("Elige un libro del cual desea conocer el autor");
        var titulo = teclado.nextLine();
   Optional<Libros> libroEncontrado= libroRegistrado.stream()
           .filter(lr->lr.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
           .findFirst();
      if (libroEncontrado.isPresent()){
          var libro= libroEncontrado.get();
          var json = consumoApi.obtenerJson(URL_BASE+titulo.replace(" ","+"));
          DatoApi datos= conversor.obtenerDatos(json, DatoApi.class);
          List<DatoApi> datosApi= new ArrayList<>();
          datosApi.add(datos);

          dlibro = datosApi.stream()
                  .flatMap(a -> a.results().stream())
                  .collect(Collectors.toList());
          Optional<DatosPersona>  person = dlibro.stream()
                  .flatMap(p -> p.autores().stream())
                  .findFirst();

          List<Personas> persna = person.stream()
                  .map(dl -> new Personas(dl))
                  .collect(Collectors.toList());
          libro.setAutores(persna);
          persna.forEach(System.out::println);
          repository.save(libro);

      }else{
          System.out.println("libro no encontrado");
      }



  }


}