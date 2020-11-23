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
public class Devolucion {
    
    private int iddevolucion;
    private String fechadevolucion;
    private int idwallet;
    private int idproducto;
    
     //constructor vacio
    public Devolucion(){  
    }
    
    //constructor para elimiar un registro
    public Devolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public Devolucion(int iddevolucion, String fechadevolucion) {
        this.iddevolucion = iddevolucion;
        this.fechadevolucion = fechadevolucion;
    }

    public Devolucion( String fechadevolucion, int idwallet, int idproducto) {
        this.fechadevolucion = fechadevolucion;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public int getIddevolucion() {
        return iddevolucion;
    }

    public String getFechadevolucion() {
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

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
    
    
    
    
}
