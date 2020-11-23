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
public class Usuario {
     private int idUsuario;
    private String nombre;
    private String password;
    
    
    //constructor vacio
    public Usuario(){
        this.idUsuario=idUsuario;
        this.nombre=nombre;
        this.password=password;
        
    }
    //constructor para borrar un usuario solo necesito el id
    public Usuario(int idUsuario){
        this.idUsuario=idUsuario;
    }
     //constructor para insertar uun nuevo regristro
    public Usuario(String nombre, String password){
        this.nombre=nombre;
        this.password=password;
        
    }
     //coonstructor para modificar un registro (se necesita todos los atributos)
    public Usuario(int idUsuario,String nombre, String password){
        this.idUsuario=idUsuario;
        this.nombre=nombre;
        this.password=password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", password=" + password + '}';
    }
    
}
