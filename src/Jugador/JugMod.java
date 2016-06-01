/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import BaseDatos.DataBase;
import Herencia.ArrayHerencia;
import Herencia.HerJugador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author alexcampos
 */
public class JugMod extends JFrame{
    private JPanel pnlMod=new JPanel();
    private JLabel lblApeJug=new JLabel("Apellido:");
    private JLabel lblNomJug=new JLabel("Nombre:");
    private JLabel lblEdad=new JLabel("Edad:");
    private JLabel lblValor=new JLabel("Valor:");
    private JLabel lblEquipo=new JLabel("Equipo:");
    private JTextField txtNomJug=new JTextField();
    private JTextField txtApeJug=new JTextField();
    private JTextField txtEdad=new JTextField();
    private JTextField txtValor=new JTextField();
    private JComboBox cbEquipo=new JComboBox();
    private JComboBox cbDNI=new JComboBox();
    private JButton btnAcep=new JButton("Aceptar");
    private JButton btnMod=new JButton("Modificar");
    private JButton btnSal=new JButton("Salir");
    private ArrayList<HerJugador> list=new ArrayList<>();
    
    public JugMod() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setResizable(false);
        this.setSize(250,250);
        this.setLocationRelativeTo(null);
        
        this.add(pnlMod);
        GridLayout pos=new GridLayout(7,2);
        pnlMod.setLayout(pos);
        pnlMod.add(cbDNI);
        pnlMod.add(btnAcep);
        pnlMod.add(lblNomJug);
        pnlMod.add(txtNomJug);
        pnlMod.add(lblApeJug);
        pnlMod.add(txtApeJug);
        pnlMod.add(lblValor);
        pnlMod.add(txtValor);
        pnlMod.add(lblEdad);
        pnlMod.add(txtEdad);
        pnlMod.add(lblEquipo);
        pnlMod.add(cbEquipo);
        pnlMod.add(btnMod);
        pnlMod.add(btnSal);
        
        String sentenciaSQL="SELECT * FROM jugador";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        int i=0;
        while(rs.next()){
            HerJugador jug=new HerJugador(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            list.add(i, jug);
            cbDNI.addItem(rs.getString(1)+", "+rs.getString(2));
            cbEquipo.addItem(rs.getString(6));
            i++;
        }
        
        btnAcep.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                txtNomJug.setText(list.get(cbDNI.getSelectedIndex()).getNombre());
                txtApeJug.setText(list.get(cbDNI.getSelectedIndex()).getApellido());
                txtValor.setText(String.valueOf(list.get(cbDNI.getSelectedIndex()).getValor()));
                txtEdad.setText(String.valueOf(list.get(cbDNI.getSelectedIndex()).getEdad()));
                cbEquipo.setSelectedItem(list.get(cbDNI.getSelectedIndex()).getNomEqui());
            }
            
        });
        
        btnMod.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String dni=list.get(cbDNI.getSelectedIndex()).getDni();
                String nom=txtNomJug.getText();
                String ape=txtApeJug.getText();
                int valor=Integer.parseInt(txtValor.getText());
                int edad=Integer.parseInt(txtEdad.getText());
                String equi=String.valueOf(cbEquipo.getSelectedItem());
                data.modificarJugador(dni, nom, ape, valor, edad, equi);
                JOptionPane.showMessageDialog(null, "Jugador Modificado");
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
