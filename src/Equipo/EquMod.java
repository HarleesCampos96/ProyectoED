/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import BaseDatos.DataBase;
import Herencia.ArrayHerencia;
import Herencia.HerEquipo;
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
public class EquMod extends JFrame {
    JPanel pnlMod=new JPanel();
    JLabel lblNomEst=new JLabel("Estadio:");
    JLabel lblPresupuesto=new JLabel("Presupuesto:");
    JLabel lblLocalidad=new JLabel("Localidad:");
    JLabel lblNomLig=new JLabel("Liga:");
    JLabel lblDNIEnt=new JLabel("Entrenador:");
    JLabel lblDNIPre=new JLabel("Presidente:");
    JLabel lblPresu=new JLabel("Presupuesto:");
    JTextField txtNomEqu=new JTextField();
    JTextField txtLocalidad=new JTextField();
    JTextField txtPresu=new JTextField();
    JComboBox cbNomEst=new JComboBox();
    JComboBox cbNomEqu=new JComboBox();
    JComboBox cbNomLig=new JComboBox();
    JComboBox cbDNIEnt=new JComboBox();
    JComboBox cbDNIPre=new JComboBox();
    JButton btnAce=new JButton("Aceptar");
    JButton btnMod=new JButton("Modificar");
    JButton btnSal=new JButton("Salir");
    private ArrayList<HerEquipo> list1=new ArrayList<>();
    private ArrayList<ArrayHerencia> list2=new ArrayList<>();
    private ArrayList<ArrayHerencia> list3=new ArrayList<>();
    private ArrayList<ArrayHerencia> list4=new ArrayList<>();
    private ArrayList<ArrayHerencia> list5=new ArrayList<>();
    
    public EquMod() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(275,225);
        
        this.add(pnlMod);
        GridLayout pos=new GridLayout(8,2);
        pnlMod.setLayout(pos);
        pnlMod.add(cbNomEqu);
        pnlMod.add(btnAce);
        pnlMod.add(lblLocalidad);
        pnlMod.add(txtLocalidad);
        pnlMod.add(lblNomEst);
        pnlMod.add(cbNomEst);
        pnlMod.add(lblPresupuesto);
        pnlMod.add(txtPresu);
        pnlMod.add(lblNomLig);
        pnlMod.add(cbNomLig);
        pnlMod.add(lblDNIEnt);
        pnlMod.add(cbDNIEnt);
        pnlMod.add(lblDNIPre);
        pnlMod.add(cbDNIPre);
        pnlMod.add(btnMod);
        pnlMod.add(btnSal);
        
        String sentenciaSQL="SELECT * FROM equipo;";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        int a=0;
        while(rs.next()){
            HerEquipo equipo=new HerEquipo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
            list1.add(a, equipo);
            cbNomEqu.addItem(rs.getString(1));
            a++;
        }
        
        String sentenciaSQL1="SELECT * FROM estadio;";
        ResultSet rsEst;
        rsEst=data.ejecutaQuery(sentenciaSQL1);
        int b=0;
        while(rsEst.next()){
            ArrayHerencia dat1=new ArrayHerencia(rsEst.getString(1));
            list2.add(b, dat1);
            cbNomEst.addItem(rsEst.getString(1));
            b++;
        }
        
        String sentenciaSQL2="SELECT * FROM liga;";
        ResultSet rsLig;
        rsLig=data.ejecutaQuery(sentenciaSQL2);
        int c=0;
        while(rsLig.next()){
            ArrayHerencia dat2=new ArrayHerencia(rsLig.getString(1));
            list3.add(c, dat2);
            cbNomLig.addItem(rsLig.getString(1));
            c++;
        }
        
        String sentenciaSQL3="SELECT * FROM entrenador";
        ResultSet rsEnt;
        rsEnt=data.ejecutaQuery(sentenciaSQL3);
        int d=0;
        while(rsEnt.next()){
            ArrayHerencia dat3=new ArrayHerencia(rsEnt.getString(1),rsEnt.getString(2));
            list4.add(d, dat3);
            cbDNIEnt.addItem(rsEnt.getString(1));
            d++;
        }
        
        
        String sentenciaSQL4="SELECT * FROM presidente;";
        ResultSet rsPre;
        rsPre=data.ejecutaQuery(sentenciaSQL4);
        int e=0;
        while(rsPre.next()){
            ArrayHerencia dat4=new ArrayHerencia(rsPre.getString(1),rsPre.getString(2));
            list5.add(e, dat4);
            cbDNIPre.addItem(rsPre.getString(1));
        }
                
        btnAce.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                txtLocalidad.setText(list1.get(cbNomEqu.getSelectedIndex()).getLocalidad());
                cbNomEst.setSelectedItem(list1.get(cbNomEqu.getSelectedIndex()).getNomEst());
                txtPresu.setText(String.valueOf(list1.get(cbNomEqu.getSelectedIndex()).getPresu()));
                cbNomLig.setSelectedItem(list1.get(cbNomEqu.getSelectedIndex()).getNomLiga());
                cbDNIEnt.setSelectedItem(list1.get(cbNomEqu.getSelectedIndex()).getDniEntre());
                cbDNIPre.setSelectedItem(list1.get(cbNomEqu.getSelectedIndex()).getDniPresi());
            }
            
        });
        
        btnMod.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String equ=list1.get(cbNomEqu.getSelectedIndex()).getNombre();
                String local=txtLocalidad.getText();
                String estad=String.valueOf(cbNomEst.getSelectedItem());
                int presu=Integer.parseInt(txtPresu.getText());
                String lig=String.valueOf(cbNomLig.getSelectedItem());
                String ent=String.valueOf(cbDNIEnt.getSelectedItem());
                String pre=String.valueOf(cbDNIPre.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Equipo modficado");
                try {
                    data.modificarEquipo(equ, local, estad, presu, lig, ent, pre);
                } catch (SQLException ex) {
                    Logger.getLogger(EquMod.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnSal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        
        this.setVisible(true);
        
    }
    
}
