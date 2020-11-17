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
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antonio
 */
public class ControllerPelicula {
    
    

    public ControllerPelicula() {
    }
    
    //llama al DAO para guardar una pelicula
	public void registrarcontroller(Pelicula pelicula ) {
		PeliculaDaoImple dao= new  PeliculaDaoImple();
		dao.registar(pelicula);
	}
        
        public DefaultTableModel selectcontroller() throws SQLException{
            DefaultTableModel model = new DefaultTableModel();
            PeliculaDaoImple dao= new  PeliculaDaoImple();
            model= dao.select();
           return model;
        }
        
        public void eliminarcontroller(Pelicula pelicula ) {
		PeliculaDaoImple dao= new  PeliculaDaoImple();
		dao.eliminar(pelicula);
	}
        public void actualizarcontroller(Pelicula pelicula){
            PeliculaDaoImple dao= new  PeliculaDaoImple();
            dao.actualizar(pelicula);
        }
    
}
