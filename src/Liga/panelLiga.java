/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liga;

import General.ExportGeneral;
import General.TablaGeneral;
import Principal.Inter_Principal;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alexcampos
 */
public class panelLiga extends JPanel{
    JButton btnCrearElim=new JButton("Crear o Eliminar nueva Liga");
    JButton btnMos=new JButton("Mostrar Tabla de Ligas");
    JButton btnExp=new JButton("Exportar Datos de las Ligas");
    public panelLiga(String cargo){
        this.setLayout(new GridLayout(3,1,5,5));
        if(cargo.equals("GERENTE")){
           this.add(btnCrearElim); 
        }
        this.add(btnMos);
        this.add(btnExp);
        
        btnCrearElim.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LigaCrearElim ligCreaElim=new LigaCrearElim();
                } catch (SQLException ex) {
                    Logger.getLogger(panelLiga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelLiga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnMos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TablaGeneral tab=new TablaGeneral("liga");
                } catch (SQLException ex) {
                    Logger.getLogger(panelLiga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelLiga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnExp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExportGeneral imp=new ExportGeneral("liga");
                } catch (SQLException ex) {
                    Logger.getLogger(panelLiga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelLiga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
}
