/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libro.data;

import com.libro.domian.Libro;
import java.util.List;
import javax.vax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose
 */
@Stateless
public class LibroDaoImpl implements LibroDao{

    @PersistenceContext (unitName = "LibroPU")
    EntityManager em;
    
    @Override
    public List<Libro> consultaGeneral() {
        return em.createNamedQuery("Libro.encontrarLibros").getResultList();
    }

    @Override
    public Libro buscarLibro(Libro libro) {
        return em.find(Libro.class, libro.getNombreLibro());
    }

    @Override
    public void insertarLibro(Libro libro) {
        em.persist(libro);
        em.flush();
    }

    @Override
    public void actualizarLibro(Libro libro) {
        em.merge(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        em.remove(em.merge(libro));
    }
    
}
