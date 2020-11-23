/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Domain.Compra;
import static datos.Conexion.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author antonio
 */
public class CompraDAO {

    //atributo 
    private Connection conexionTransaccional;

    //  sentencias de acceso a la BD
    private static final String SQL_SELECT = "SELECT * FROM compra";
    private static final String SQL_INSERT = "INSERT INTO compra(FechaCompra,Id_wallet,Id_producto) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona=?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellidos=?, edad=? where idpersona=?";

    //constructor vacio
    //Para recibir el objeto conexión desde dentro de la clase. Sola para manejar una transaccion interna
    public CompraDAO() {

    }

    //Para recibir el objeto conexión desde fuera de la clase
    public CompraDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public int insertarcompra(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            //signific que ya esta abierta la conexion no abrir conexion  sino conectar
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setDate(1, compra.getFechacompra());
            stmt.setInt(2, compra.getIdwallet());
            stmt.setInt(3, compra.getIdproducto());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" insertwallet " + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizar(Ewallet wallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, wallet.getNombre());
            stmt.setString(2, wallet.getApellidos());
            stmt.setString(3, wallet.getDni());
            stmt.setDate(4, wallet.getFechanacimento());
            stmt.setString(5, wallet.getEmail());
            stmt.setInt(6, wallet.getSaldopuntos());
            stmt.setInt(7, wallet.getSaldoeuros());
            stmt.setInt(8, wallet.getIdwallet());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" actualiarwallet " + ex.getMessage());
            }

        }
        return registros;
    }

    public int borrar(Ewallet wallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, wallet.getIdwallet());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" borrarwallet " + ex.getMessage());
            }

        }
        return registros;
    }

}
