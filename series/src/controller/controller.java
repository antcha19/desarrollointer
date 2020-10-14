/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.access;
import model.listShow;
import model.show;

/**
 *
 * @author antcha
 */
public class controller {
    private int position;
    private listShow ls ;
    private access acc = new access();
    
    
    public controller(){
        position=0;
        ls=new listShow();
        //cargar a la listaShow
        ls=acc.loadLS();
    }
    public show first(){
        position=0;
        return ls.getShow(position);
    }
    public show previous(){
       if( position>0){
           position--;
       }
        return ls.getShow(position);
    }

    public show next(){
        position++;
        if (position==ls.longuitud()){
            position--;
        }
        return ls.getShow(position);
    }
    public show last(){
       position=ls.longuitud()-1;
        return ls.getShow(position);
    }
    public show update(){
         return ls.getShow(position);
    }
    public void nuevo(show s){
        ls.setShow(s);
        position=ls.longuitud()-1;
        acc.saveLS(ls);
    }
    
    public void delete(){
        ls.removeShow(position);
        //guardo la lista
        access.saveLS(ls);
       
    }

}
