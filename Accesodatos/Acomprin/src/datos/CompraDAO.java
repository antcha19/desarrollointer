/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Domain.Compra;
import static datos.Conexion.close;
import java.sql.*;
import java.util.*;
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
    private static final String SQL_INSERT = "INSERT INTO compra(FechaCompra,Id-wallet,Id_producto) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM compra WHERE Id_compra=?";
    private static final String SQL_UPDATE = "UPDATE compra SET FechaCompra=?, Id_wallet=?, Id_producto=? where Id_compra=?";

    //constructor vacio
    //Para recibir el objeto conexión desde dentro de la clase. Sola para manejar una transaccion interna
    public CompraDAO() {

    }

    //Para recibir el objeto conexión desde fuera de la clase
    public CompraDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Compra> seleccionarcompra() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra;
        List<Compra> compralista = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idcompra = rs.getInt("Id_compra");
                Date fechacompra = rs.getDate("Fechacompra");
                int idwallet = rs.getInt("Id-wallet");
                int idproducto = rs.getInt("Id_producto");
                compra = new Compra(idcompra, fechacompra, idwallet, idproducto);
                compralista.add(compra);
            }
        } finally {

            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return compralista;
    }

    public int insertarcompra(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            //signific que ya esta abierta la conexion no abrir conexion  sino conectar
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
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
                System.out.println(" insertarcompra " + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizarcompra(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, compra.getFechacompra());
            stmt.setInt(2, compra.getIdwallet());
            stmt.setInt(3, compra.getIdproducto());
            stmt.setInt(4, compra.getIdcompra());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" actualizarcompra " + ex.getMessage());
            }

        }
        return registros;
    }

    public int borrarcompra(Compra compra) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getIdcompra());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" borrarcompra " + ex.getMessage());
            }

        }
        return registros;
    }

}
