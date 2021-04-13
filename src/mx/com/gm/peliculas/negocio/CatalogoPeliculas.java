package mx.com.gm.peliculas.negocio;

public interface CatalogoPeliculas {

    String NOMBRE_RECURSO = "Peliculas.txt";

    void agregarPeliculas(String nombrePelicula);

    void listarPeliculas();

    void buscarPelicula(String buscar);

    void iniciarCatalogoPeliculas();
}
