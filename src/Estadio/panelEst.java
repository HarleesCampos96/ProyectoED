/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadio;

import General.ExportGeneral;
import General.TablaGeneral;
import Jugador.*;
import Liga.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alexcampos
 */
public class panelEst extends JPanel{
    JButton btnCreBor=new JButton("Insertar o Borrar Estadio");
    JButton btnMos=new JButton("Mostrar Tabla de Estadios");
    JButton btnExp=new JButton("Exportar Datos de los Estadios");
    
    public panelEst(String cargo){
        this.setLayout(new GridLayout(3,1,5,5));
        if(cargo.equals("GERENTE")){
            this.add(btnCreBor);
        }
        this.add(btnMos);
        this.add(btnExp);
        
        btnCreBor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EstaInsBor estaInsBor=new EstaInsBor();
                } catch (SQLException ex) {
                    Logger.getLogger(panelEst.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEst.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TablaGeneral tab=new TablaGeneral("estadio");
                } catch (SQLException ex) {
                    Logger.getLogger(panelEst.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEst.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnExp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExportGeneral imp=new ExportGeneral("estadio");
                } catch (SQLException ex) {
                    Logger.getLogger(panelEst.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEst.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
}
