/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;


import java.sql.Date;

/**
 *
 * @author antonio
 */
public class Devolucion {
    
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
