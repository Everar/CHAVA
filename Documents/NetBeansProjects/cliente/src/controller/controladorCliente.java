/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import modelo.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EVE
 */
public class controladorCliente implements ActionListener{

    Jfcliente vistacliente = new Jfcliente();
    personaDAD modeloDAD = new personaDAD();
    
    
    public controladorCliente(Jfcliente vistacliente,personaDAD moeloDAD ){
        this.modeloDAD = moeloDAD;
        this.vistacliente = vistacliente;
        this.vistacliente.btnRegistrar.addActionListener(this);
        this.vistacliente.BtnListar.addActionListener(this);
    }
    
    public void InicialisarCliente(){
        
    }
    
    public void LLenarTable(JTable tablaD){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("DNI");
        modeloT.addColumn("APELLIDOS");
        modeloT.addColumn("NOMBRES");
        modeloT.addColumn("FECHA N");
        modeloT.addColumn("LUGAR N");
            
        Object [] columna = new Object[5];
        
        int numRegistros = modeloDAD.listPersona().size();
        
        for (int i = 0; i < 10; i++) {
           columna[0] =modeloDAD.listPersona().get(i).getDni();
           columna[1] =modeloDAD.listPersona().get(i).getApellido();
           columna[2] =modeloDAD.listPersona().get(i).getNombres();
           columna[3] =modeloDAD.listPersona().get(i).getFechaN();
           columna[4] =modeloDAD.listPersona().get(i).getLugarN();
           modeloT.addColumn(columna);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource()== vistacliente.btnRegistrar){
            String dni = vistacliente.txtDni.getText();
            String apellidos = vistacliente.txtApellidos.getText();
            String nombres = vistacliente.TxtNombres.getText();
            String fechaN =  vistacliente.fechaN.getText();
            String lugarN = vistacliente.TxtLugar.getText();
            
            
          
            String rptaRegistro = modeloDAD.insertPersona(dni, apellidos, nombres, fechaN, lugarN);
        
            if(rptaRegistro!=null){
                JOptionPane.showConfirmDialog(null, rptaRegistro);
                
            }else{
                JOptionPane.showConfirmDialog(null, "Registro Erroneo");
            }
            
        }
        
        if(e.getSource()== vistacliente.BtnListar){
            LLenarTable(vistacliente.jtDatos);
        }
        
    }
    
    
}
