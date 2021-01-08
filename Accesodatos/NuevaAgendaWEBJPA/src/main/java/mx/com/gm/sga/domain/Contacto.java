/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author antcha
 */
@Entity
// de que tabla se llama contactos
@Table (name="contactos")
public class Contacto  implements Serializable{
    
    private static final long SerialVersionUID=1l;
    //lprimary key
    @Id
     //la id es auto incrementable
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //nombre de la tabla
   // @Column(name="idContacto")
    private int idContacto;
    private String nombre;
    private String email;
    private int telefono;

    public Contacto() {
    }

    public Contacto(int idContacto) {
        this.idContacto = idContacto;
    }
    

    public Contacto(String nombre, String email, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "idcontacto=" + idContacto + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
    
    
    
}
