/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "compra")
public class Compra {
     private static final long SerialVersionUID=1l;
    //primary key
    @Id
    //id es autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //nombre de las columnas de la tabla
    @Column(name="idcompra")
    private int idcompra;
    private Date fechacompra;
    private int idwallet;
    private int idproducto;
    
    
    @JoinColumn(name="idwallet", referencedColumnName="idwallet")
    @ManyToOne
    private Ewallet ewallet;

    public Compra() {
    }

    public Compra(int idcompra) {
        this.idcompra = idcompra;
    }

    public Compra(Date fechacompra, int idwallet, int idproducto) {
        this.fechacompra = fechacompra;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public Compra(int idcompra, Date fechacompra, int idwallet, int idproducto) {
        this.idcompra = idcompra;
        this.fechacompra = fechacompra;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
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
