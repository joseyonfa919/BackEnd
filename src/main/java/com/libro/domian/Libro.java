package com.libro.domian;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jose
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Libro.encontrarLibros", query = "SELECT l FROM Libro l ORDER BY l.nombre")
})
public class Libro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre")    
    
    private String nombreLibro;
    private String descripcionLibro;
    private String autorLibro;
    private String fechaLibro;
    private int numeroEjemplares;
    private double precioLibro;
            
    public Libro() {
        
    }
    
    public Libro(String nombre) {
        this.nombreLibro = nombre;
    }
    
    public Libro(String nombre, String descripcion, String autor, String fecha, int ejemplares, double precio) {
        this.nombreLibro = nombre;
        this.descripcionLibro = descripcion;
        this.autorLibro = autor;
        this.fechaLibro = fecha;
        this.numeroEjemplares = ejemplares;
        this.precioLibro = precio;
    }   

        public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getDescripcionLibro() {
        return descripcionLibro;
    }

    public void setDescripcionLibro(String descripcionLibro) {
        this.descripcionLibro = descripcionLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getFechaLibro() {
        return fechaLibro;
    }

    public void setFechaLibro(String fechaLibro) {
        this.fechaLibro = fechaLibro;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombreLibro + ", descripcion=" + descripcionLibro + ", autor=" + autorLibro + ", fecha=" + fechaLibro + ", ejemplares=" + numeroEjemplares + ", costo=" + precioLibro + '}';
    }
    
    
}
