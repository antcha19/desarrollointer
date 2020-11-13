/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//importamos librerias


import domain.Pelicula;
import datos.PeliculaDAO;
import datos.Conexion;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class main {

    public static void main(String[] args) throws SQLException {
       

        /*PeliculaDAO peliDAO = new PeliculaDAO();
        List<Pelicula> peliculas = peliDAO.seleccionarpeli();
        

       
                    System.out.println("propietarios");

                    peliculas.forEach(Pelicula -> {
                        System.out.println("propietarios = " + Pelicula);
                    });*/
        
        frameproyecto2 f= new frameproyecto2();
        f.setVisible(true);

                    
           
     


   
    }
}
