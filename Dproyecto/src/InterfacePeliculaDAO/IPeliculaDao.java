/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacePeliculaDAO;

import Modelo.Pelicula;

import java.util.List;

/**
 *
 * @author antonio
 */
//al ser interface solo contiene la firma de los métodos
public interface IPeliculaDao {
    
    public boolean registar(Pelicula pelicula);
    //arraylist
    public List<Pelicula> obtener();
    public boolean actualizar(Pelicula pelicula);
    public boolean eliminar(Pelicula pelicula);

    
}
