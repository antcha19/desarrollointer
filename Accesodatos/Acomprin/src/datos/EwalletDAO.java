/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Domain.Ewallet;

import java.sql.*;

/**
 *
 * @author antonio
 */
public class EwalletDAO {

    //atributo 
    private Connection conexionTransaccional;

    //  sentencias de acceso a la BD
    private static final String SQL_SELECT = "SELECT * FROM ewallet";
    private static final String SQL_INSERT = "INSERT INTO ewallet(Nombre, Apellidos, Dni ,Fechanacimiento,Email, Saldopuntos, Saldoeuros) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM ewallet WHERE id-wallet=?";
    private static final String SQL_UPDATE = "UPDATE ewallet SET Nombre=?, Apellidos=?, Dni=? Fechanacimiento=?, Saldopuntos=?,Saldoeuros=? where id-wallet=?";

    //constructor vacio
    //Para recibir el objeto conexión desde dentro de la clase. Sola para manejar una transaccion interna
    public EwalletDAO() {

    }

    //Para recibir el objeto conexión desde fuera de la clase
    public EwalletDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Ewallet> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ewallet wallet = null;
        List<Ewallet> walletlista = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id-wallet");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                Date fechanacimento;
                fechanacimento = rs.getDate("Fechanacimiento");
                String email = rs.getString("Email");
                int saldopuntos = rs.getInt("Saldopuntos");
                int saldoeuros = rs.getInt("Saldoeuros");

                wallet = new Ewallet(idPersona, nombre, apellidos, email, fechanacimento, email, saldopuntos, saldoeuros);
                walletlista.add(wallet);

            }
        } finally {
            //   Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return walletlista;
    }

    public int insertar(Ewallet wallet) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            //signific que ya esta abierta la conexion no abrir conexion  sino conectar
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, wallet.getNombre());
            stmt.setString(2, wallet.getApellidos());
            stmt.setString(3, wallet.getDni());
            stmt.setDate(4, wallet.getFechanacimento());
            stmt.setString(5, wallet.getEmail());
            stmt.setInt(6, wallet.getSaldopuntos());
            stmt.setInt(7, wallet.getSaldoeuros());
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
