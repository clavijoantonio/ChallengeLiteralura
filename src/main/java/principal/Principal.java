package principal;

import model.DatosLibros;
import service.ConsumoApi;
import service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoDatos = new ConsumoApi();
    private final String URL_BASE="https://gutendex.com/books?";
    private ConvierteDatos conversor = new ConvierteDatos();

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
    public void buscarLibrosPorTitulo() {
        System.out.println("Ingresa el libro que desea buscar: ");
        String titulo = teclado.nextLine();
        var json = consumoDatos.obtenerDatos(URL_BASE+ "search=dickens%20"+titulo.replace("","+"));
        DatosLibros datos= conversor.obtenerDatos(json,DatosLibros.class);
        System.out.println(datos);
    }
}