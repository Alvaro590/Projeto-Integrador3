/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.naminhamaquinafunciona.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    
    private static Connection c = null;
    
    public static Connection getConnection(){
    
        if(c != null){
            return c;
        }else{
        
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "admin";
            
            try {
                Class.forName(driver);
                c = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return c;
        
        }
    }
}

