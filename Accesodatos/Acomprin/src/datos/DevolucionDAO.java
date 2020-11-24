/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import Domain.Devolucion;
import static datos.Conexion.close;
import java.sql.*;
import java.util.*;
import java.sql.Date;
/**
 *
 * @author antonio
 */
public class DevolucionDAO {
     //atributo 
    private Connection conexionTransaccional;

    //  sentencias de acceso a la BD
    private static final String SQL_SELECT = "SELECT * FROM devolucion";
    private static final String SQL_INSERT = "INSERT INTO devolucion(FechaDevolucion,Id-wallet,Id_producto) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM devolucion WHERE Id_devolucion=?";
    private static final String SQL_UPDATE = "UPDATE devolucion SET FechaDevolucion=?, Id-wallet=?, Id_producto=? where Id_devolucion=?";

    //constructor vacio
    //Para recibir el objeto conexión desde dentro de la clase. Sola para manejar una transaccion interna
    public DevolucionDAO() {

    }

    //Para recibir el objeto conexión desde fuera de la clase
    public DevolucionDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Devolucion> seleccionardevolucion() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Devolucion devolu;
        List<Devolucion> devolucionlista = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iddevolucion = rs.getInt("Id_devolucion");
                Date fechadevolucion = rs.getDate("FechaDevolucion");
                int idwallet = rs.getInt("Id-wallet");
                int idproducto = rs.getInt("Id_producto");
                devolu =  new Devolucion(iddevolucion, fechadevolucion, idwallet, idproducto);
                devolucionlista.add(devolu);
            }
        } finally {

            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return devolucionlista;
    }

    public int insertardevolucion(Devolucion devolucion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            //signific que ya esta abierta la conexion no abrir conexion  sino conectar
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setDate(1, devolucion.getFechadevolucion());
            stmt.setInt(2, devolucion.getIdwallet());
            stmt.setInt(3, devolucion.getIdproducto());
 
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" insertardevolucion " + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizardevolucion(Devolucion devolucion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, devolucion.getFechadevolucion());
            stmt.setInt(2, devolucion.getIdwallet());
            stmt.setInt(3, devolucion.getIdproducto());
            stmt.setInt(4, devolucion.getIddevolucion());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" actualizardevolucion " + ex.getMessage());
            }

        }
        return registros;
    }

    public int borrardevolcion(Devolucion devolucion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, devolucion.getIddevolucion());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" borrardevolucion " + ex.getMessage());
            }

        }
        return registros;
    }
    
}
