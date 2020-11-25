/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Domain.Producto;
import static datos.Conexion.close;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonio
 */
public class ProductoDAO {
    
     //atributo 
    private Connection conexionTransaccional;

    //  sentencias de acceso a la BD
    private static final String SQL_SELECT = "SELECT * FROM producto";
    private static final String SQL_INSERT = "INSERT INTO producto( NombreProducto, PrecioProducto ,PuntosProducto) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE Id_producto=?";
    private static final String SQL_UPDATE = "UPDATE producto SET NombreProducto=?, PrecioProducto=?, PuntosProducto=?  where Id_producto=?";

    //constructor vacio
    //Para recibir el objeto conexión desde dentro de la clase. Sola para manejar una transaccion interna
    public ProductoDAO() {

    }

    //Para recibir el objeto conexión desde fuera de la clase
    public ProductoDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Producto> seleccionarproducto() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productolista = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idproducto = rs.getInt("Id_producto");
                String nombreproducto = rs.getString("NombreProducto");
                int precioproducto = rs.getInt("PrecioProducto");
                int puntosproducto = rs.getInt("PuntosProducto");
                producto = new Producto(idproducto, nombreproducto, precioproducto, puntosproducto);
                productolista.add(producto);
            }
        } finally {
           
            Conexion.close(stmt);
            Conexion.close(rs);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return productolista;
    }

    public int insertarproducto(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            //signific que ya esta abierta la conexion no abrir conexion  sino conectar
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombreproduto());
            stmt.setInt(2, producto.getPrecioproducto());
            stmt.setInt(3, producto.getPuntosproducto());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(" insertproducto " + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizarproducto(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombreproduto());
            stmt.setInt(2, producto.getPrecioproducto());
            stmt.setInt(3, producto.getPuntosproducto());
            stmt.setInt(4, producto.getIdproducto());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                 System.out.println(" actualizarproducto " + ex.getMessage());
            }

            
        }
        return registros;
    }

    public int borrarproducto(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdproducto());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                 System.out.println(" borrarproducto " + ex.getMessage());
            }

        }
        return registros;
    }

    
    
    
}
