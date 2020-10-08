/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class listShow implements Serializable{
    private ArrayList<show> serieslist;
    
    
    public listShow(){
        serieslist = new ArrayList<>();
    }
    
    
    public show getShow(int p){
        return serieslist.get(p);
    }
    public void setShow(show s){
         serieslist.add(s);
    }
    public int longuitud(){
        return serieslist.size();
    }

    
    
}
