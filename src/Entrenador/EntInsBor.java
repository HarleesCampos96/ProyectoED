/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrenador;

import BaseDatos.DataBase;
import Presidente.*;
import Estadio.*;
import Herencia.ArrayHerencia;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alexcampos
 */
public class EntInsBor extends JFrame{
    JPanel pnlIns=new JPanel();
    JPanel pnlBor=new JPanel();
    JLabel lblNomEnt=new JLabel("Nombre:");
    JLabel lblApeEnt=new JLabel("Apellido:");
    JLabel lblDNI=new JLabel("DNI:");
    JLabel lblEdad=new JLabel("Edad:");
    JLabel lblSueldo=new JLabel("Sueldo:");
    JTextField txtNomEnt=new JTextField();
    JTextField txtApeEnt=new JTextField();
    JTextField txtDNI=new JTextField();
    JTextField txtEdad=new JTextField();
    JTextField txtSueldo=new JTextField();
    JComboBox combo=new JComboBox();
    JButton btnIns=new JButton("Insertar");
    JButton btnBor=new JButton("Borrar");
    JButton btnSali1=new JButton("Salir");
    JButton btnSali2=new JButton("Salir");
    JTabbedPane pestaña=new JTabbedPane();
    ArrayList<ArrayHerencia> list=new ArrayList<>();
    
    public EntInsBor() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pestaña.add("Ins. Entren.",pnlIns);
        pestaña.add("Bor. Entren.",pnlBor);
        
        GridLayout pos=new GridLayout(6,2);
        pnlIns.setLayout(pos);
        pnlIns.add(lblDNI);
        pnlIns.add(txtDNI);
        pnlIns.add(lblNomEnt);
        pnlIns.add(txtNomEnt);
        pnlIns.add(lblApeEnt);
        pnlIns.add(txtApeEnt);
        pnlIns.add(lblEdad);
        pnlIns.add(txtEdad);
        pnlIns.add(lblSueldo);
        pnlIns.add(txtSueldo);
        pnlIns.add(btnIns);
        pnlIns.add(btnSali1);
        
        btnIns.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String dni=txtDNI.getText();
                    String nom=txtNomEnt.getText();
                    String ape=txtApeEnt.getText();
                    int sue=Integer.parseInt(txtSueldo.getText());
                    int ed=Integer.parseInt(txtEdad.getText());
                    data.insertarEntrenador(dni, nom, ape, sue, ed);
                    JOptionPane.showMessageDialog(null, "Entrenador Insertado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                }
            }
            
        });
        
        btnSali1.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
              dispose(); 
           }
            
        });
        
        GridLayout pos1=new GridLayout(3,1,5,5);
        pnlBor.setLayout(pos1);
        pnlBor.add(combo);
        pnlBor.add(btnBor);
        pnlBor.add(btnSali2);
        
        String sentenciaSQL="SELECT * FROM entrenador;";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        int x=0;
        while(rs.next()){
            ArrayHerencia dat=new ArrayHerencia(rs.getString(1), rs.getString(2));
            list.add(x, dat);
            combo.addItem(rs.getString(1) +", " + rs.getString(2));
            x++;
        }
        
        btnBor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String dni=list.get(combo.getSelectedIndex()).getId();
                String sentenciaSQL1="DELETE FROM entrenador WHERE dni_entre = '" + dni +"';" ;
                data.ejecutarUpdate(sentenciaSQL1);
                JOptionPane.showMessageDialog(null, "Entrenador borrado");
            }
            
        });
        
        btnSali2.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
              dispose(); 
           }
            
        });
        
        this.add(pestaña);
        this.setVisible(true);
        
    }
}
