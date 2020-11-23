/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author antonio
 */
public class Producto {

    private int idproducto;
    private String nombreproduto;
    private int precioproducto;
    private int puntosproducto;
    private int stock;

    public Producto() {

    }

    public Producto(String nombreproduto, int precioproducto, int puntosproducto, int stock) {
        this.nombreproduto = nombreproduto;
        this.precioproducto = precioproducto;
        this.puntosproducto = puntosproducto;
        this.stock = stock;
    }

    public Producto(int idproducto, String nombreproduto, int precioproducto, int puntosproducto, int stock) {
        this.idproducto = idproducto;
        this.nombreproduto = nombreproduto;
        this.precioproducto = precioproducto;
        this.puntosproducto = puntosproducto;
        this.stock = stock;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public String getNombreproduto() {
        return nombreproduto;
    }

    public int getPrecioproducto() {
        return precioproducto;
    }

    public int getPuntosproducto() {
        return puntosproducto;
    }

    public int getStock() {
        return stock;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setNombreproduto(String nombreproduto) {
        this.nombreproduto = nombreproduto;
    }

    public void setPrecioproducto(int precioproducto) {
        this.precioproducto = precioproducto;
    }

    public void setPuntosproducto(int puntosproducto) {
        this.puntosproducto = puntosproducto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    

}
