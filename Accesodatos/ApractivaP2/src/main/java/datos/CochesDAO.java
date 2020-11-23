/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

//importamos librerias necesarias
import java.sql.*;
import domain.Coches;
import java.util.*;
import datos.Conexion;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;

/**
 *
 * @author antonio
 */
public class CochesDAO {

    //sentencia para seleccionar en sql
    private static final String SQL_SELECT = "SELECT  Matricula, Marca, Precio, DNI FROM coches";
    private static final String SQL_INSERT = "INSERT INTO coches(Matricula, Marca, Precio,DNI) VALUES (?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM coches where Matricula=?";
    private static final String SQL_UPDATE = "UPDATE coches SET Marca=?, Precio=? where  Matricula=?";


    public List<Coches> seleccionarcoches() throws SQLException {
        //llamamos a todas las conexiones
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coches coche = null;
        //array de coches
        List<Coches> listcoches = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idmatricula = rs.getString("Matricula");
                String marca = rs.getString("Marca");
                int precio = rs.getInt("Precio");
                String DNI = rs.getString("DNI");
                coche = new Coches(idmatricula, marca, precio, DNI);
                listcoches.add(coche);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return listcoches;
    }

    public int insertar(Coches coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, coche.getIdmatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDNI());
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

    public int borrar(Coches coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, coche.getIdmatricula());
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

    public int actualizar(Coches coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, coche.getMarca());
            stmt.setInt(2, coche.getPrecio());
            stmt.setString(3, coche.getIdmatricula());
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
