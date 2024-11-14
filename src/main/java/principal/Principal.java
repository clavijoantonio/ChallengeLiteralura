package principal;

import service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoDatos = new ConsumoApi();

    public void obtenerDatosApi() {

        var json = consumoDatos.obtenerDatos("https://gutendex.com/books/");
        System.out.println(json);
    }
}