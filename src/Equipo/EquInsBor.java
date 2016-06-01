/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

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
public class EquInsBor extends JFrame{
    JPanel pnlIns=new JPanel();
    JPanel pnlBor=new JPanel();
    JLabel lblNomEqu=new JLabel("Nombre:");
    JLabel lblNomEst=new JLabel("Estadio:");
    JLabel lblPresupuesto=new JLabel("Presupuesto:");
    JLabel lblLocalidad=new JLabel("Localidad:");
    JLabel lblNomLig=new JLabel("Liga:");
    JLabel lblDNIEnt=new JLabel("Entrenador:");
    JLabel lblDNIPre=new JLabel("Presidente:");
    JLabel lblPresu=new JLabel("Presupuesto:");
    JTextField txtNomEqu=new JTextField();
    JComboBox cbNomEst=new JComboBox();
    JTextField txtLocalidad=new JTextField();
    JTextField txtPresu=new JTextField();
    JComboBox cbNomLig=new JComboBox();
    JComboBox cbDNIEnt=new JComboBox();
    JComboBox cbDNIPre=new JComboBox();
    JComboBox combo=new JComboBox();
    JButton btnIns=new JButton("Insertar");
    JButton btnBor=new JButton("Borrar");
    JButton btnSali1=new JButton("Salir");
    JButton btnSali2=new JButton("Salir");
    JTabbedPane pestaña=new JTabbedPane();
    private ArrayList<ArrayHerencia> list1=new ArrayList<>();
    private ArrayList<ArrayHerencia> list2=new ArrayList<>();
    private ArrayList<ArrayHerencia> list3=new ArrayList<>();
    private ArrayList<ArrayHerencia> list4=new ArrayList<>();
    private ArrayList<ArrayHerencia> list5=new ArrayList<>();
    
    public EquInsBor() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setSize(275,225);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pestaña.add("Ins. Equipo",pnlIns);
        pestaña.add("Bor. Equipo.",pnlBor);
        
        GridLayout pos=new GridLayout(8,2);
        pnlIns.setLayout(pos);
        pnlIns.add(lblNomEqu);
        pnlIns.add(txtNomEqu);
        pnlIns.add(lblNomLig);
        pnlIns.add(cbNomLig);
        pnlIns.add(lblLocalidad);
        pnlIns.add(txtLocalidad);
        pnlIns.add(lblNomEst);
        pnlIns.add(cbNomEst);
        pnlIns.add(lblDNIPre);
        pnlIns.add(cbDNIPre);
        pnlIns.add(lblDNIEnt);
        pnlIns.add(cbDNIEnt);
        pnlIns.add(lblPresu);
        pnlIns.add(txtPresu);
        pnlIns.add(btnIns);
        pnlIns.add(btnSali1);
        
        String sentLigSQL="SELECT * FROM liga;";
        ResultSet rsLig;
        rsLig=data.ejecutaQuery(sentLigSQL);
        int i=0;
        while(rsLig.next()){
            ArrayHerencia dat1=new ArrayHerencia(rsLig.getString(1),rsLig.getString(2));
            list1.add(i,dat1);
            cbNomLig.addItem(rsLig.getString(1) +", " + rsLig.getString(2));
            i++;
        }
        
        String sentEstSQL="SELECT * FROM estadio;";
        ResultSet rsEst;
        rsEst=data.ejecutaQuery(sentEstSQL);
        int x=0;
        while(rsEst.next()){
            ArrayHerencia dat2=new ArrayHerencia(rsEst.getString(1));
            list2.add(x,dat2);
            cbNomEst.addItem(rsEst.getString(1));
            x++;
        }
        
        String sentEntSQL="SELECT * FROM entrenador;";
        ResultSet rsEnt;
        rsEnt=data.ejecutaQuery(sentEntSQL);
        int y=0;
        while(rsEnt.next()){
            ArrayHerencia dat3=new ArrayHerencia(rsEnt.getString(1),rsEnt.getString(2));
            list3.add(y,dat3);
            cbDNIEnt.addItem(rsEnt.getString(1)+ ", " + rsEnt.getString(2));
            y++;
        }
        
        String sentEquSQL="SELECT * FROM presidente;";
        ResultSet rsEqu;
        rsEqu=data.ejecutaQuery(sentEquSQL);
        int z=0;
        while(rsEqu.next()){
            ArrayHerencia dat4=new ArrayHerencia(rsEqu.getString(1),rsEqu.getString(2));
            list4.add(z,dat4);
            cbDNIPre.addItem(rsEqu.getString(1)+ ", " + rsEqu.getString(2));
            z++;
        }
        
        btnIns.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String equ = txtNomEqu.getText();
                    String local = txtLocalidad.getText();
                    String est = list2.get(cbNomEst.getSelectedIndex()).getId();
                    int presu = Integer.parseInt(txtPresu.getText());
                    String lig = list1.get(cbNomLig.getSelectedIndex()).getId();
                    String ent = list3.get(cbDNIEnt.getSelectedIndex()).getId();
                    String pre = list4.get(cbDNIPre.getSelectedIndex()).getId();
                    System.out.println(equ +" "+ local +" "+ est+" "+ presu+" "+ lig+ " "+ ent+ " " + pre);
                    data.insertarEquipo(equ, local, est, presu, lig, ent, pre);
                    JOptionPane.showMessageDialog(null, "Equipo insertado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Equipo insertado");
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
        
        String sentenciaSQL="SELECT * FROM equipo";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        int a=0;
        while(rs.next()){
            ArrayHerencia dat=new ArrayHerencia(rs.getString(1),rs.getString(2));
            list5.add(a, dat);
            combo.addItem(rs.getString(1)+", "+rs.getString(2));
            a++;
        }
        
        btnBor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String nom=list5.get(combo.getSelectedIndex()).getId();
                String sentenciaSQL1="DELETE FROM equipo WHERE nom_equi = '" + nom +"';";
                data.ejecutarUpdate(sentenciaSQL1);
                JOptionPane.showMessageDialog(null, "Equipo Eliminado");
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
