package com.libro.data;

import com.libro.domian.Libro;
import java.util.List;

/**
 *
 * @author Jose
 */
public interface LibroDao {
    public List<Libro> consultaGeneral();
    public Libro buscarLibro(Libro libro);
    public void insertarLibro(Libro libro);
    public void actualizarLibro(Libro libro);
    public void eliminarLibro(Libro libro);
}
