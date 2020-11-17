/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author antonio
 */
public class Pelicula {
    
    private int id;
    private String nombre;
    private int anyo;
    private String tipo;

    public Pelicula() {
    }

    //update un registro
    public Pelicula(int id, String nombre, int anyo, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.anyo = anyo;
        this.tipo = tipo;
    }
    //insertar un registro
    public Pelicula( String nombre, int anyo, String tipo) {
       
        this.nombre = nombre;
        this.anyo = anyo;
        this.tipo = tipo;
    }

    //eliminar registro
    public Pelicula(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", anyo=" + anyo + ", tipo=" + tipo + '}';
    }
    
    
}
