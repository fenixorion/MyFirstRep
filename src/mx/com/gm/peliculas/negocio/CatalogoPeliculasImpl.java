package mx.com.gm.peliculas.negocio;

import java.io.*;
import java.util.List;
import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void agregarPeliculas(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try{
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso de datos.");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try{
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try{
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
            if(resultado == null){
                System.out.println("No se encontro el nombre de pelicula especificado"); 
            }else{
                System.out.println("resultado = " + resultado);
            }
        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        
    }
    

    @Override
    public void iniciarCatalogoPeliculas() {
        try{
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
                }
            }catch(AccesoDatosEx ex){
                System.out.println("Error al crear nuevo Catalogo de Peliculas");
                ex.printStackTrace(System.out);
            }
    }

}
