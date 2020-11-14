/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Vista.VistaPelicula;
import InterfacePeliculaDAO.IPeliculaDao;
import Modelo.Pelicula;
import ImplementacionDAO.PeliculaDaoImple;
import java.util.ArrayList;
import java.util.List;
        
/**
 *
 * @author antonio
 */
public class ControllerPelicula {
    
    private VistaPelicula vista =  new VistaPelicula();

    public ControllerPelicula() {
    }
    
    //llama al DAO para guardar una pelicula
	public void registrar(Pelicula pelicula ) {
		IPeliculaDao dao= new  PeliculaDaoImple();
		dao.registar(pelicula);
	}
        
        public void listarpeliculas(){
            List<Pelicula> listapeliculas = new ArrayList<Pelicula>();
            IPeliculaDao listadao = new PeliculaDaoImple();
            listapeliculas=listadao.obtener();
            vista.verPeliculas(listapeliculas);
        }
    
}
