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
public class Compra {
    
    private int idcompra;
    private Date fechacompra;
    private int idwallet;
    private int idproducto;

    public Compra() {
    }

    public Compra(int idcompra, Date fechacompra, int idwallet, int idproducto) {
        this.idcompra = idcompra;
        this.fechacompra = fechacompra;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public Compra(Date fechacompra, int idwallet, int idproducto) {
        this.fechacompra = fechacompra;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public Compra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public int getIdwallet() {
        return idwallet;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public String toString() {
        return "Compra{" + "idcompra=" + idcompra + ", fechacompra=" + fechacompra + ", idwallet=" + idwallet + ", idproducto=" + idproducto + '}';
    }
    
    
   
    
    
    
}
