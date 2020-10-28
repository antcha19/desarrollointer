/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author antcha
 */
public class client {
    
    private String id;
    private String notes;
    
    //constructor
    public client(){
        this.id="";
        this.notes="";
        
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public String Muestra() {
       return id + notes;
    }
    
}
