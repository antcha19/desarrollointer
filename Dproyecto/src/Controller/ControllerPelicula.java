/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import Modelo.Pelicula;
import ImplementacionDAO.PeliculaDaoImple;
import java.util.ArrayList;
import java.util.List;
import Vista.Dproyecto1;

/**
 *
 * @author antonio
 */
public class ControllerPelicula {
    
    private  Dproyecto1 vista =  new Dproyecto1();

    public ControllerPelicula() {
    }
    
    //llama al DAO para guardar una pelicula
	public void registrar(Pelicula pelicula ) {
		PeliculaDaoImple dao= new  PeliculaDaoImple();
		dao.registar(pelicula);
	}
        
        public void listarpeliculas(){
            List<Pelicula> listapeliculas = new ArrayList<Pelicula>();
            PeliculaDaoImple listadao = new PeliculaDaoImple();
            listapeliculas=listadao.obtener();
           
        }
        
        public void eliminar(Pelicula pelicula ) {
		PeliculaDaoImple dao= new  PeliculaDaoImple();
		dao.eliminar(pelicula);
	}
        public void actualizar(Pelicula pelicula){
            PeliculaDaoImple dao= new  PeliculaDaoImple();
            dao.actualizar(pelicula);
        }
    
}
