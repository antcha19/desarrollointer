/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series;

import model.access;
import model.listShow;
import model.show;
import view.frame;
import controller.controller;

/**
 *
 * @author antcha
 */
public class Series {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //instancio un controlador para pasarselo a la vista
        controller c = new controller();
        frame f = new frame(c);
        f.setVisible(true);
    
        
            //instancia a list of series
          listShow ls = new listShow();
            //read the file
            ls=access.loadLS();
            //create a serie
            show sh= new show();
            //obtengo el primer elemento del arraylist
            sh=ls.getShow(0);
            System.out.println("title");
            System.out.println(sh.getTitle());
            //obtengo el 2 elemento
            sh = ls.getShow(1);
            System.out.println(sh.getTitle());
    
    
    
    
       //creamios una instancia de una serie
      /*  show sh=new show("Breaking bad", "Vicent",5,"drama",5,"hbo");
        //creo a list
        listShow ls = new listShow();
                //add the serie
        ls.setShow(sh);
        sh=new show("games of trones", "Vicent2",6,"1",6,"Netflix");
        ls.setShow(sh);
        //guardo 
        access.saveLS(ls);
        System.out.println("saved series");*/
    }
    
}
