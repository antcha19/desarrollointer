/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
import DAO.client;

/**
 *
 * @author antcha
 */
public class all {

    public static ArrayList<client> obtainData()  {
        //arraly de client
        ArrayList<client> listac = new ArrayList<>();
        
        try {

            //acceder a la base de datos , tambien tenemos  que selecionas el driver
            String url0dbc = "jdbc:mysql://localhost:3306/di?useSSL=false";

            Connection conexion=(java.sql.DriverManager.getConnection(url0dbc, "root", "serpis"));
            Statement instruccion = conexion.createStatement();
            //sentencia sql 
            ResultSet resultado = instruccion.executeQuery("select * from clients");

            while (resultado.next()) {
                client c = new client();
                c.setId(resultado.getString("id"));
                c.setNotes(resultado.getString("notes"));
                listac.add(c);
            }

            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("error indatabase");
        }
        return listac;
    }

}
