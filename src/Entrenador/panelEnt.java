/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrenador;

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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author alexcampos
 */
public class panelEnt extends JPanel {

    JButton btnCreBa = new JButton("Insertar o dar de Baja Entrenador");
    JButton btnMos = new JButton("Mostrar Tabla de Entrenadores");
    JButton btnExp = new JButton("Exportar Datos de los Entrenadores");
    JButton btnExpXML = new JButton("Exportar a XML Datos de los Entrenadores");

    public panelEnt(String cargo) {
        this.setLayout(new GridLayout(4, 1, 0, 5));
        if (cargo.equals("GERENTE")) {
            this.add(btnCreBa);
        }
        this.add(btnMos);
        this.add(btnExp);
        this.add(btnExpXML);

        btnCreBa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EntInsBor entInsBor = new EntInsBor();
                } catch (SQLException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnMos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TablaGeneral tab = new TablaGeneral("entrenador");
                } catch (SQLException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnExp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExportGeneral imp = new ExportGeneral("entrenador");
                } catch (SQLException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnExpXML.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EntXML entXML = new EntXML();
                    JOptionPane.showMessageDialog(null, "Se ha Guardado Correctamente en la raíz del Proyecto");
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(panelEnt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }
}
