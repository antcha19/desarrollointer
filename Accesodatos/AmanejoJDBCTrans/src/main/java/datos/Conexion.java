/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
/**
 *
 * @author antcha
 */
public class Conexion {
    /*conexion  la bbdd , link que siempre sera asi
    tambien el usuario y la contraseña*/
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone="
                + "true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="serpis";
    
   public static Connection getConnection() throws SQLException{
      return DriverManager.getConnection  (JDBC_URL, JDBC_USER, JDBC_PASSWORD);
   }
   public static void close (ResultSet rs) throws SQLException{
       rs.close();
   }
    public static void close (Statement smtm) throws SQLException{
       smtm.close();
   }
     public static void close (Connection conn) throws SQLException{
       conn.close();
   }
  
    
}

 