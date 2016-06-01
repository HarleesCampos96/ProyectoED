/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import BaseDatos.DataBase;
import Entrenador.*;
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
public class JugInsBor extends JFrame{
    JPanel pnlIns=new JPanel();
    JPanel pnlBor=new JPanel();
    JLabel lblNomJug=new JLabel("Nombre:");
    JLabel lblApeJug=new JLabel("Apellido:");
    JLabel lblDNI=new JLabel("DNI:");
    JLabel lblEdad=new JLabel("Edad:");
    JLabel lblValor=new JLabel("Valor:");
    JLabel lblEquipo=new JLabel("Equipo:");
    JTextField txtNomJug=new JTextField();
    JTextField txtApeJug=new JTextField();
    JTextField txtDNI=new JTextField();
    JTextField txtEdad=new JTextField();
    JTextField txtValor=new JTextField();
    JComboBox cbEquipo=new JComboBox();
    JComboBox combo=new JComboBox();
    JButton btnIns=new JButton("Insertar");
    JButton btnBor=new JButton("Borrar");
    JButton btnSali1=new JButton("Salir");
    JButton btnSali2=new JButton("Salir");
    JTabbedPane pestaña=new JTabbedPane();
    ArrayList<ArrayHerencia> list=new ArrayList<>();
    ArrayList<ArrayHerencia> list1=new ArrayList<>();
    
    public JugInsBor() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pestaña.add("Ins. Jugador",pnlIns);
        pestaña.add("Bor. Jugador",pnlBor);
        
        GridLayout pos=new GridLayout(7,2);
        pnlIns.setLayout(pos);
        pnlIns.add(lblDNI);
        pnlIns.add(txtDNI);
        pnlIns.add(lblNomJug);
        pnlIns.add(txtNomJug);
        pnlIns.add(lblApeJug);
        pnlIns.add(txtApeJug);
        pnlIns.add(lblEdad);
        pnlIns.add(txtEdad);
        pnlIns.add(lblEquipo);
        pnlIns.add(cbEquipo);
        pnlIns.add(lblValor);
        pnlIns.add(txtValor);
        pnlIns.add(btnIns);
        pnlIns.add(btnSali1);
        
        ResultSet rs;
        String sentenciaSQL="SELECT * FROM equipo;";
        rs=data.ejecutaQuery(sentenciaSQL);
        int a=0;
        while(rs.next()){
            ArrayHerencia dat=new ArrayHerencia(rs.getString(1));
            list.add(a,dat);
            cbEquipo.addItem(rs.getString(1));
        }
        
        btnIns.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String dni=txtDNI.getText();
                    String nom=txtNomJug.getText();
                    String ape=txtApeJug.getText();
                    int val= Integer.parseInt(txtValor.getText());
                    int eda= Integer.parseInt(txtEdad.getText());
                    String equ= list.get(cbEquipo.getSelectedIndex()).getId();
                    
                    data.insertarJugador(dni, nom, ape, val, eda, equ);
                    JOptionPane.showMessageDialog(null, "Jugador insertado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido algún error");
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
        
        String sentenciaSQL1="SELECT * FROM jugador;";
        ResultSet rs1;
        rs1=data.ejecutaQuery(sentenciaSQL1);
        int b=0;
        while(rs1.next()){
            ArrayHerencia dat=new ArrayHerencia(rs1.getString(1), rs1.getString(2));
            list1.add(b, dat);
            combo.addItem(rs1.getString(1)+ ", " + rs1.getString(2));
            b++;
            }
        
        btnBor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String dni=list1.get(combo.getSelectedIndex()).getId();
                String sentenciaSQL2="DELETE FROM jugador WHERE dni ='" + dni +"';";
                data.ejecutarUpdate(sentenciaSQL2);
                JOptionPane.showMessageDialog(null, "Jugador borrado");
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
