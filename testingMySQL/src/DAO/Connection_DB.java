/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
/**
 *
 * @author antcha
 */
public class Connection_DB {
    
    public Connection openConnection() throws Exception{
        Connection con = null;
        try{
             String urlOdbc = "jdbc:mysql://localhost:3306/di?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
             con = (java.sql.DriverManager.getConnection (urlOdbc, "root", "serpis")); 
             return con;
        }catch(Exception e){
            e.printStackTrace();
             throw new Exception ("Connection could not be established" + e.getMessage ());
        }
        
    }
    public void CloseConnection (Connection con)throws Exception{
        try{
            if (con!= null) con.close();   
        }catch(SQLException e){
            e.printStackTrace();
            throw new Exception("it was impossible to close the Conecction " + e.getMessage());
        }
    }
    
}
    
