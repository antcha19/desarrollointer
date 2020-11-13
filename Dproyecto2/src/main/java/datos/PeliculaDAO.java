/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

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
    private static final String SQL_INSERT = "INSERT INTO coches(Matricula, Marca, Precio,DNI) VALUES (?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM coches where Matricula=?";
    private static final String SQL_UPDATE = "UPDATE coches SET Marca=?, Precio=? where  Matricula=?";

    public List<Pelicula> seleccionarpeli() throws SQLException {
        //llamamos a todas las conexiones
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pelicula pelicula = null;
        //array de coches
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

}
