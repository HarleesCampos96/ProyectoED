/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presidente;

import BaseDatos.DataBase;
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
public class PreInsBor extends JFrame{
    JPanel pnlIns=new JPanel();
    JPanel pnlBor=new JPanel();
    JLabel lblNomPre=new JLabel("Nombre:");
    JLabel lblApePre=new JLabel("Apellido:");
    JLabel lblDNI=new JLabel("DNI:");
    JLabel lblEdad=new JLabel("Edad:");
    JTextField txtNomPre=new JTextField();
    JTextField txtApePre=new JTextField();
    JTextField txtDNI=new JTextField();
    JTextField txtEdad=new JTextField();
    JComboBox combo=new JComboBox();
    JButton btnIns=new JButton("Insertar");
    JButton btnBor=new JButton("Borrar");
    JButton btnSali1=new JButton("Salir");
    JButton btnSali2=new JButton("Salir");
    JTabbedPane pestaña=new JTabbedPane();
    ArrayList<ArrayHerencia> list=new ArrayList<>();
    
    public PreInsBor() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pestaña.add("Ins. Presi.",pnlIns);
        pestaña.add("Bor. Presi.",pnlBor);
        
        GridLayout pos=new GridLayout(5,2,5,5);
        pnlIns.setLayout(pos);
        pnlIns.add(lblDNI);
        pnlIns.add(txtDNI);
        pnlIns.add(lblNomPre);
        pnlIns.add(txtNomPre);
        pnlIns.add(lblApePre);
        pnlIns.add(txtApePre);
        pnlIns.add(lblEdad);
        pnlIns.add(txtEdad);
        pnlIns.add(btnIns);
        pnlIns.add(btnSali1);
        
        btnIns.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String dni= txtDNI.getText();
                String nom= txtNomPre.getText();
                String ape= txtApePre.getText();
                int eda= Integer.parseInt(txtEdad.getText());
                try {
                    data.insertarPresidente(dni, nom, ape, eda);
                    JOptionPane.showMessageDialog(null, "Presidente Insertado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido algún fallo");
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
        
        String sentenciaSQL="SELECT * FROM presidente;";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        int x=0;
        while(rs.next()){
            ArrayHerencia dat=new ArrayHerencia(rs.getString(1), rs.getString(2));
            list.add(x, dat);
            combo.addItem(rs.getString(1)+", "+ rs.getString(2));
            x++;
        }
        
        btnBor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String dni=list.get(combo.getSelectedIndex()).getId();
                String sentenciaSQL="DELETE FROM presidente WHERE dni_presi='" + dni + "'; ";
                data.ejecutarUpdate(sentenciaSQL);
                JOptionPane.showMessageDialog(null, "Presidente Borrado");
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
