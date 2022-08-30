/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miriam
 */
public class BDConexao {
     private static  String DRIVER_CLASS_MYSQL= "com.mysql.jdbc.Driver";
    private static  String URL_MYSQL="jdbc:mysql://localhost/consultorio";
    private static String USER = "root";
    private static String PASS = "";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER_CLASS_MYSQL);
            
            return DriverManager.getConnection(URL_MYSQL,USER,PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDConexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDConexao.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
        public void close(Connection con, PreparedStatement stmt, ResultSet rs){
         try{
             if(con!=null){
                 con.close();
             }
             if(stmt!=null){
                 stmt.close();
             }
             if(rs!=null){
                 rs.close();
                 
             }
         } catch (SQLException ex) {
            Logger.getLogger(BDConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
