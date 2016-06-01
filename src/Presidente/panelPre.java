/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presidente;

import Estadio.*;
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
public class panelPre extends JPanel{
    JButton btnCreBa=new JButton("Insertar o Dar de Baja Presidente");
    JButton btnMos=new JButton("Mostrar Tabla de Presidentes");
    JButton btnExp=new JButton("Exportar Datos de los Presidentes");
    
    public panelPre(String cargo){
        this.setLayout(new GridLayout(3,1,0,5));
        if(cargo.equals("GERENTE")){
        this.add(btnCreBa);
        }
        this.add(btnMos);
        this.add(btnExp);
        
        btnCreBa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreInsBor preInsBor=new PreInsBor();
                } catch (SQLException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TablaGeneral tab=new TablaGeneral("presidente");
                } catch (SQLException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnExp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExportGeneral imp=new ExportGeneral("presidente");
                } catch (SQLException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
}
