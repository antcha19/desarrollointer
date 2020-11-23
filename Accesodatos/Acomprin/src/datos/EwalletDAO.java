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

/**
 *
 * @author antonio
 */
public class EwalletDAO {
    
    //atributo 
    private Connection conexionTransaccional;

    //  sentencias de acceso a la BD
    private static final String SQL_SELECT = "SELECT id-wallet, Nombre, Apellidos,Fechanacimiento, Saldopuntos, Saldoeuros  FROM ewallet";
    private static final String SQL_INSERT = "INSERT INTO ewallet(Nombre,Apellidos,Fechanacimiento, Saldopuntos, Saldoeuros) VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM ewallet WHERE id-wallet=?";
    private static final String SQL_UPDATE = "UPDATE ewallet SET Nombre=?, Apellidos=?, Fechanacimiento=?, Saldopuntos=?,Saldoeuros=? where id-wallet=?";
  
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
        List<Ewallet> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id-wallet");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                int edad = rs.getInt("fecha");
                persona = new Persona(idPersona, nombre, apellidos, edad);
                personas.add(persona);
            }
        } finally {
            //   Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            //signific que ya esta abierta la conexion no abrir conexion  sino conectar
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
          
            stmt.setInt(3, persona.getEdad());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
            }
            /*  try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }*/

        }
        return registros;
    }

    public int actualizar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
            }

            /* try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }*/
        }
        return registros;
    }

    public int borrar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }
    
}
