/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author antcha
 */
@Entity

// de que tabla se llama contactos
@Table (name="usuarios")

@NamedQueries({
    @NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUserAndPwd", query="SELECT u FROM Usuario u where u.usuario=?1 and u.password=?2")

})
public class Usuario implements Serializable{
    
     private static final long SerialVersionUID=1l;
    //lprimary key
    @Id
     //la id es auto incrementable
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //nombre de la tabla
    private int idUsuario;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    public Usuario(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
}
