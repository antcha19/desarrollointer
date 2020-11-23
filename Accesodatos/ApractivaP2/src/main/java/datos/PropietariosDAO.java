/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Coches;
import domain.Propietarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonio
 */
public class PropietariosDAO {
    //sentencia para seleccionar en sql

    private static final String SQL_SELECT = "SELECT  DNI, Nombre, Edad FROM propietarios";
     private static final String SQL_INSERT = "INSERT INTO propietarios(DNI, Nombre, Edad) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM propietarios WHERE DNI=?";
    private static final String SQL_UPDATE = "UPDATE propietarios SET Nombre=?, Edad=? where DNI=?";

    // método para realizar la sentencia SELECT
    public List<Propietarios> seleccionarpropietarios() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietarios propietario = null;
        List<Propietarios> listpropietario = new ArrayList<>();
        
        try {
            //hacemos la conexion a la bbdd
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            //devuelve la base de datos
            rs = stmt.executeQuery();
            //recoremos la tabla 
            while (rs.next()) {
                //rs.getString en su caso cogemos los datos de la tabla y lo guardamos
                String idDNI = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                propietario = new Propietarios(idDNI, nombre, edad);
                listpropietario.add(propietario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return listpropietario;
    }
     public int insertar(Propietarios propietarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //setstring para guardar datos en la bbdd
            stmt.setString(1, propietarios.getIdDNI());
            stmt.setString(2, propietarios.getNombre());
            stmt.setInt(3,propietarios.getEdad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);

            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int borrarpro(Propietarios propietarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, propietarios.getIdDNI());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);

            } catch (SQLException ex) {
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     public int actualizarpropietarios (Propietarios propietarios){
         //conexiones
         Connection conn = null;
         //preparamos para la consulta
         PreparedStatement stmt = null;
         int registros = 0;
         try{
             //hacemos la conexcion
             conn = getConnection();
             stmt = conn.prepareStatement(SQL_UPDATE);
             
             //pasamos todos los valores
             stmt.setString(1, propietarios.getNombre());
             stmt.setInt(2, propietarios.getEdad());
             stmt.setString(3,propietarios.getIdDNI());
             registros = stmt.executeUpdate();
         }catch(SQLException ex){ 
             ex.printStackTrace(System.out);
         }finally{
             //cerramos las conexiones
             try{
                 close(stmt);
             }catch(SQLException ex){
                 
             }
             try{
                 close(conn);
             }catch(SQLException ex){
                 ex.printStackTrace(System.out);
             }
         }
         //devolvemos los registros
         return  registros;
     }

}
