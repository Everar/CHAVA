/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
/**
 *
 * @author EVE
 */
public class conexion {
    
    public conexion(){
        
    }
    
    public Connection getConnection(){
        Connection con = null;
        
       try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bd_persona","root","56789");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return con;
    }
    
}

