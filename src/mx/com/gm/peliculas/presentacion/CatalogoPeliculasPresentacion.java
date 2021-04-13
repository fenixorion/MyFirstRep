package mx.com.gm.peliculas.presentacion;

import java.util.*;
import mx.com.gm.peliculas.negocio.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        Scanner sc = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion \n"
                    + "1.- Iniciar catalogo peliculas.\n"
                    + "2.- Agregar pelicula.\n"
                    + "3.- Listar peliculas.\n"
                    + "4.- Buscar pelicula.\n"
                    + "0.- Salir.");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    var nombre = sc.nextLine();
                    catalogo.agregarPeliculas(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de una pelicula: ");
                    var buscar = sc.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Operacion no reconocida");
                    break;
            }
        }
    }
}
