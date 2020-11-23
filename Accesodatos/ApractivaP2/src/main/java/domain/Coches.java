/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author antonio
 */
public class Coches {

    private String idmatricula;
    private String marca;
    private int precio;
    private String DNI;

    //constructor vacio
    public Coches() {
        this.idmatricula = idmatricula;
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    //	Constructor que proporciona sólo el ID 
    public Coches(String idmatricula) {
        this.idmatricula = idmatricula;
    }

    //constructor para insertar nuveo registro
    public Coches(String marca, int precio, String DNI) {
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    //modificar un registro
    public Coches(String idmatricula, String marca, int precio, String DNI) {
        this.idmatricula = idmatricula;
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    //constructor para actualizar un registro
    public Coches(String idmatricula, String marca, int precio) {
        this.idmatricula = idmatricula;
        this.marca = marca;
        this.precio = precio;
    }

    public String getIdmatricula() {
        return idmatricula;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setIdmatricula(String idmatricula) {
        this.idmatricula = idmatricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Coches{" + "idmatricula=" + idmatricula + ", marca=" + marca + ", precio=" + precio + ", DNI=" + DNI + '}';
    }

}
