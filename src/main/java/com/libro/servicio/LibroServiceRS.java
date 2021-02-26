package com.libro.servicio;

import com.libro.data.LibroDao;
import com.libro.domian.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose
 */
@Stateless
@Path("/libros")
public class LibroServiceRS {
    
    @Inject
    private LibroDao libroDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Libro> listar() {
        List<Libro> libros = libroDao.consultaGeneral();
        System.out.println("Libros encontrados: " + libros);
        return libros;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public Libro buscarLibro(@PathParam("nombre") String nombre) {
        Libro libro = libroDao.buscarUno(new Libro(nombre));
        System.out.println("Libro encontrado:" + libro);
        return libro;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Libro agregar(Libro libro) {
        libroDao.insertarLibro(libro);
        System.err.println("Libro agregado: " + libro);
        return libro;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public Response editar(@PathParam("nombre") String nombre, Libro editar) {
        Libro libro = libroDao.buscarLibro(new Libro(nombre));
        if(libro != null) {
            libroDao.actualizarLibro(editar);
            System.out.println("Libro modificado: " + editar);
            return Response.ok().entity(editar).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public Response eliminar(@PathParam("nombre") String nombre) {
        libroDao.eliminarLibro(new Libro(nombre));
        System.out.println("El libro: " + nombre +" ha sido eliminado");
        return Response.ok().build();
    }
}
