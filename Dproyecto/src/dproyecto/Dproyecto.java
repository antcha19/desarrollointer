/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dproyecto;

import Controller.ControllerPelicula;
import Modelo.Pelicula;

/**
 *
 * @author antonio
 */
public class Dproyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Pelicula pelicula = new Pelicula("avatar", 2014, "cienca ficcion");
        //Controllador
        ControllerPelicula controller = new ControllerPelicula();
        controller.registrar(pelicula);

    }
}
