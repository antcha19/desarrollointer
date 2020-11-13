/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Pelicula;
import java.util.List;

/**
 *
 * @author antonio
 */
public class VistaPelicula {
    
    public void verPelicula(Pelicula pelicula){
        System.out.println("datos de la pelicula " + pelicula);
    }
    public void verPeliculas(List<Pelicula> peliculas){
        for (Pelicula pelicula : peliculas) {
			System.out.println("Datos del peliculas: "+pelicula);
		}
    }
}
