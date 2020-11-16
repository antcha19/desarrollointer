/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Pelicula;
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
public class PeliculaDAO {

    //sentencia para seleccionar en sql
    private static final String SQL_SELECT = "SELECT id, Nombre, Anyo, Tipo FROM pelicula";
    private static final String SQL_INSERT = "INSERT INTO pelicula( Nombre, Anyo,Tipo) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM pelicula where id=?";
    private static final String SQL_UPDATE = "UPDATE pelicula SET Nombre=?, Anyo=?, Tipo=? where  id=?";

    public List<Pelicula> seleccionarpeli() throws SQLException {
        //llamamos a todas las conexiones
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pelicula pelicula = null;
        //array de listapeliculas
        List<Pelicula> lispeliculas = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("Nombre");
                int anyo = rs.getInt("Anyo");
                String tipo = rs.getString("Tipo");
                pelicula = new Pelicula(id, nombre, anyo, tipo);
                lispeliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return lispeliculas;
    }
    
     public int borrar(Pelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pelicula.getId());
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
     public int insertar(Pelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getNombre());
            stmt.setInt(2, pelicula.getAnyo());
            stmt.setString(3, pelicula.getTipo());
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
     
     public int actualizar(Pelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombre());
            stmt.setInt(2, pelicula.getAnyo());
            stmt.setString(3, pelicula.getTipo());
            stmt.setInt(4, pelicula.getId());
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
}
