
package mx.com.gm.sga.domain;

import java.io.Serializable;

import javax.persistence.*;

//la clase es una entidad 
@Entity

public class Persona  implements  Serializable{
    private static final long SerialVersionUID=1L;
    //la clave primary jey es la id
    @Id
    //la id es auto incrementable
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idpersona")
    private int idpersona;
    private String nombre;
    private String apellidos;
    private String email;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + '}';
    }

    
    
    
}
