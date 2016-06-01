/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import Estadio.*;
import General.ExportGeneral;
import General.TablaGeneral;
import Jugador.*;
import Liga.*;
import Presidente.panelPre;
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
public class panelEqu extends JPanel{
    JButton btnCreBa=new JButton("Crear o dar de Baja Equipo");
    JButton btnMos=new JButton("Mostrar Tabla de Equipos");
    JButton btnExp=new JButton("Exportar Datos de los Equipos");
    JButton btnMod=new JButton("Modificar Datos de los Equipos");
    
    public panelEqu(String cargo){
        this.setLayout(new GridLayout(4,1,0,5));
        if(cargo.equals("GERENTE")){
            this.add(btnCreBa);
            this.add(btnMod);
        }
        this.add(btnMos);
        this.add(btnExp);
        
        btnCreBa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EquInsBor equInsBor=new EquInsBor();
                } catch (SQLException ex) {
                    Logger.getLogger(panelEqu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEqu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMod.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EquMod equMod=new EquMod();
                } catch (SQLException ex) {
                    Logger.getLogger(panelEqu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEqu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TablaGeneral tab=new TablaGeneral("equipo");
                } catch (SQLException ex) {
                    Logger.getLogger(panelEqu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEqu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnExp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExportGeneral imp=new ExportGeneral("equipo");
                } catch (SQLException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
    }
}
