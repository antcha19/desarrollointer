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
public class Compra {
    
    private int idcompra;
    private String fechacompra;
    private int idwallet;
    private int idproducto;
    
    //constructor vacio
    public Compra(){
    }
    //constructor para elimiar un registro
    public Compra(int idcompra){
        this.idcompra=idcompra;
    }
    
     //constructor para insertar un nuevo registro
    public Compra(int idcompra, String fechacompra) {
        this.idcompra = idcompra;
        this.fechacompra = fechacompra;
    }
    
     //para modificar un registro 
    public Compra(int idcompra, String fechacompra, int idwallet, int idproducto) {
        this.idcompra = idcompra;
        this.fechacompra = fechacompra;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }
    
    //getters

    public int getIdcompra() {
        return idcompra;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public int getIdwallet() {
        return idwallet;
    }

    public int getIdproducto() {
        return idproducto;
    }
    
    //setters

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
    
    
}
