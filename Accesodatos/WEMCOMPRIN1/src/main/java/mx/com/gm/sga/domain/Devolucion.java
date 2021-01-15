/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.sql.Date;
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
//nombre de la tabla
@Table(name="devolucion")
public class Devolucion {
    
     private static final long SerialVersionUID=1l;
    //primary key
    @Id
    //id es autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //nombres de las columnas de la tabla
    private int iddevolucion;
    private Date fechadevolucion;
    private int idwallet;
    private int idproducto;

    public Devolucion() {
    }

    public Devolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public Devolucion(Date fechadevolucion, int idwallet, int idproducto) {
        this.fechadevolucion = fechadevolucion;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public Devolucion(int iddevolucion, Date fechadevolucion, int idwallet, int idproducto) {
        this.iddevolucion = iddevolucion;
        this.fechadevolucion = fechadevolucion;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public int getIddevolucion() {
        return iddevolucion;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public int getIdwallet() {
        return idwallet;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIddevolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "iddevolucion=" + iddevolucion + ", fechadevolucion=" + fechadevolucion + ", idwallet=" + idwallet + ", idproducto=" + idproducto + '}';
    }
    
    
    
}
