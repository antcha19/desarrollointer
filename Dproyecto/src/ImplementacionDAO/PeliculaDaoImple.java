/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementacionDAO;

import InterfacePeliculaDAO.IPeliculaDao;
import Modelo.Pelicula;
import com.connection.Conexion;
import static com.connection.Conexion.close;
import java.util.List;
import java.sql.*;

/**
 *
 * @author antonio
 */
public class PeliculaDaoImple implements IPeliculaDao {

    @Override
    public boolean registar(Pelicula pelicula) {
         boolean registar = false;
        Statement stm = null;
        Connection conn = null;
        
        String sqlinsert="INSERT INTO pelicula values (NULL,'"+pelicula.getId()+"','"+pelicula.getNombre()+"','"+pelicula.getAnyo()+"','"+pelicula.getTipo()+"')";
        try{
            conn=Conexion.getConnection();
            stm=conn.createStatement();
            stm.execute(sqlinsert);
            registar=true;
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registar;
    }

    @Override
    public List<Pelicula> obtener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Pelicula pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Pelicula pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   

   

}
