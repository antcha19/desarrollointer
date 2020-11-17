/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementacionDAO;

import Modelo.Pelicula;
import com.connection.Conexion;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import Controller.ControllerPelicula;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antonio
 */
public class PeliculaDaoImple extends ControllerPelicula {

    public void registar(Pelicula pelicula) {
        boolean registar = false;
        Statement stm = null;
        Connection conn = null;

      
         String sqlinsert = "INSERT INTO pelicula values ('" + pelicula.getId() + "','" + pelicula.getNombre()+ "','" + pelicula.getAnyo() +  "','" + pelicula.getTipo()+ "')";
        try {
            conn = Conexion.getConnection();
            stm = conn.createStatement();
            stm.execute(sqlinsert);
            registar = true;
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //  return registar;
    }

    public DefaultTableModel select() throws SQLException{
        DefaultTableModel model = new DefaultTableModel();

        String sqlselect = "SELECT id,Nombre,Anyo,Tipo FROM pelicula ";
        //conexiones
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
     
         int rowNumber = 0;
        Object[] tags = new Object[4];
        tags[0] = "id";
        tags[1] = "Nombre";
        tags[2] = "Anyo";
        tags[3] = "Tipo";
        
        model.setColumnIdentifiers(tags);

        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlselect);

            while (rs.next()) {
                // se crea y rellena la fila para el modelo de la tabla
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = rs.getObject(1);
                rowData[1] = rs.getObject(2);
                rowData[2] = rs.getObject(3);
                rowData[3] = rs.getObject(4);
                model.addRow(rowData);
                rowNumber++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return model;

    }

    public boolean actualizar(Pelicula pelicula) {
          String SQL_UPDATE = "UPDATE pelicula SET Nombre='" + pelicula.getNombre() + "', Anyo='" + pelicula.getAnyo() + "', Tipo='" + pelicula.getTipo()  + " WHERE id=" + pelicula.getId();
        Connection connect = null;
        Statement stm = null;
        boolean update = false;
 
        try {
            connect = Conexion.getConnection();
            stm = connect.createStatement();
            stm.execute(SQL_UPDATE);
            update = true;
        } catch (SQLException e) {
            System.out.println("Error: peliculaDaoImple, método actualizar");
            e.printStackTrace();
        }
        return  update;
    }

    public void eliminar(Pelicula pelicula) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM pelicula WHERE ID=" + pelicula.getId();
        try {
            connect = Conexion.getConnection();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error:  ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
        //return eliminar;
    }

}
