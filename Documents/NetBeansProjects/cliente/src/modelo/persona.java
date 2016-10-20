/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author EVE
 */
public class persona {
  
    String dni;
    String apellido;
    String nombres;
    String fechaN;
    String lugarN;
    
    
    public persona(){
       dni="";
       apellido="";
       nombres="";
       fechaN="";
       lugarN="";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getLugarN() {
        return lugarN;
    }

    public void setLugarN(String lugarN) {
        this.lugarN = lugarN;
    }
    
    
}
