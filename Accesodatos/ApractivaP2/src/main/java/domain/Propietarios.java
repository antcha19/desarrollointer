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
public class Propietarios {
    
    private String idDNI;
    private String nombre;
    private int edad;
    
    
    //constructor vacio
    public Propietarios(){
        this.idDNI=idDNI;
        this.nombre=nombre;
        this.edad=edad;
    }
    
    //constructor para elimiar un registro
    public Propietarios(String idDNI){
         this.idDNI=idDNI;
    }

    //constructor para insertar un nuevo registro
    public Propietarios(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    //para modificar un registro 
    public Propietarios(String idDNI,String nombre, int edad){
        this.idDNI=idDNI;
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getIdDNI() {
        return idDNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setIdDNI(String idDNI) {
        this.idDNI = idDNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Propietarios{" + "idDNI=" + idDNI + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
