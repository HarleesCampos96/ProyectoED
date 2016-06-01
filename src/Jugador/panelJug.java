/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import General.ExportGeneral;
import General.TablaGeneral;
import Liga.*;
import Presidente.panelPre;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alexcampos
 */
public class panelJug extends JPanel{
    JButton btnCreBa=new JButton("Insertar o dar de Baja Jugador");
    JButton btnMos=new JButton("Mostrar Tabla de Jugadores");
    JButton btnExp=new JButton("Exportar Datos de los Jugadores");
    JButton btnImp=new JButton("Importar Datos de los Jugadores");
    JButton btnMod=new JButton("Modificar Jugador");
    JFileChooser fc=new JFileChooser();
    
    public panelJug(String cargo){
        this.setLayout(new GridLayout(5,1,0,5));
        if(cargo.equals("GERENTE")){
           this.add(btnCreBa);
           this.add(btnMod);
           this.add(btnImp);
        }
        this.add(btnMos);
        this.add(btnExp);
        
        btnCreBa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JugInsBor jugInsBor=new JugInsBor();
                } catch (SQLException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMod.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JugMod jugMod=new JugMod();
                } catch (SQLException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TablaGeneral tab=new TablaGeneral("jugador");
                } catch (SQLException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnExp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExportGeneral imp=new ExportGeneral("jugador");
                } catch (SQLException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnImp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fc.showOpenDialog(btnImp);
                    File file=fc.getSelectedFile();
                    System.out.println(file);
                    JugImp imp=new JugImp(file);
                    JOptionPane.showMessageDialog(null, "Se ha insertado a la Tabla LIGA, los jugadores del archivo jugador.txt");
                } catch (SQLException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(panelJug.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
}
