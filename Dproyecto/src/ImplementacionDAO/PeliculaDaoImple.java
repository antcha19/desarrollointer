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
import java.util.ArrayList;

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
            stm.close();
            conn.close();
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        return registar;
    }

    @Override
    public List<Pelicula> obtener() {
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs=null;
		
		String sql="SELECT * FROM pelicula ORDER BY ID";
		
		List<Pelicula> listaCliente= new ArrayList<Pelicula>();
		
		try {			
			conn= Conexion.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula c=new Pelicula();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setAnyo(rs.getInt(3));
				c.setTipo(rs.getString(4));
				listaCliente.add(c);
			}
			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
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
