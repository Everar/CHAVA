/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author EVE
 */
public class personaDAD {
    conexion conexion;
    
    public personaDAD(){
        conexion conexion;
     
        
    }      
        
      public String insertPersona(String dni, String apellidos, String nombres, String fecha, String lugar ){
     String rptaRegistro=null;
         try {
             Connection accesoDB = conexion.getConnection();
            CallableStatement cs = accesoDB.prepareCall("call ap_insertPersona(?,?,?,?,?)");
            cs.setString(1, dni);
            cs.setString(2, apellidos);
            cs.setString(3, nombres);
            cs.setString(4, fecha);
            cs.setString(5, lugar);
            
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
             rptaRegistro="Registro exitoso.";
            }
            
         } catch (Exception e) {
         }
     return rptaRegistro;
    }
  
     public ArrayList<persona> listPersona(){
         ArrayList listaPersona = new ArrayList();
      persona persona;  
         try {
             Connection acceDB = conexion.getConnection();
             PreparedStatement ps = acceDB.prepareStatement("select * from persona");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
              persona = new persona();
              persona.setDni(rs.getNString(1));
              persona.setApellido(rs.getNString(2));
              persona.setNombres(rs.getNString(3));
              persona.setFechaN(rs.getNString(4));
              persona.setLugarN(rs.getNString(5));
              listaPersona.add(persona);
             }
         } catch (Exception e) {
         }
        
        return listaPersona;
     }
     
}
   