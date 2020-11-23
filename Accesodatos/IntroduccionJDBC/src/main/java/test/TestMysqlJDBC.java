 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.sql.*;

/**
 *
 * @author antcha
 */
public class TestMysqlJDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone="
                + "true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //puede ser que sea requerido lo siguiente
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root","serpis");
            Statement instruccion = (Statement) conexion.createStatement();
            String sql = "Select id_persona,Nombre,Apellidos,Edad from persona";
            ResultSet resultado = instruccion.executeQuery(sql);
           while (resultado.next()){
                System.out.println("id_persona: " + resultado.getInt("id_persona"));
                System.out.println("nombre: " + resultado.getString("Nombre"));
                System.out.println("Apellidos " + resultado.getString("Apellidos"));
                System.out.println("Edad: " + resultado.getInt("Edad"));

            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
