/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author antonio
 */
@Entity
// de que tabla se llama contactos
@Table (name="producto")
public class Producto {
    private static final long SerialVersionUID=1l;
    //lprimary key
    @Id
     //la id es auto incrementable
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int idproducto;
    private String nombreproducto;
    private int precioproducto;
    private int puntosproducto;

    public Producto() {
    }

    public Producto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(String nombreproducto, int precioproducto, int puntosproducto) {
        this.nombreproducto = nombreproducto;
        this.precioproducto = precioproducto;
        this.puntosproducto = puntosproducto;
    }

    public Producto(int idproducto, String nombreproducto, int precioproducto, int puntosproducto) {
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
        this.precioproducto = precioproducto;
        this.puntosproducto = puntosproducto;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public int getPrecioproducto() {
        return precioproducto;
    }

    public int getPuntosproducto() {
        return puntosproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public void setPrecioproducto(int precioproducto) {
        this.precioproducto = precioproducto;
    }

    public void setPuntosproducto(int puntosproducto) {
        this.puntosproducto = puntosproducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombreproducto=" + nombreproducto + ", precioproducto=" + precioproducto + ", puntosproducto=" + puntosproducto + '}';
    }

   
    
    
    
}
