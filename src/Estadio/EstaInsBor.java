/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadio;

import BaseDatos.DataBase;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alexcampos
 */
public class EstaInsBor extends JFrame{
    JPanel pnlIns=new JPanel();
    JPanel pnlBor=new JPanel();
    JLabel lblNomEst=new JLabel("Nombre:");
    JLabel lblAfo=new JLabel("Aforo:");
    JTextField txtNomEst=new JTextField();
    JTextField txtAfo=new JTextField();
    JComboBox combo=new JComboBox();
    JButton btnIns=new JButton("Insertar");
    JButton btnBor=new JButton("Borrar");
    JButton btnSali1=new JButton("Salir");
    JButton btnSali2=new JButton("Salir");
    JTabbedPane pestaña=new JTabbedPane();
    
    public EstaInsBor() throws SQLException, ClassNotFoundException{
        DataBase data=new DataBase();
        this.setSize(200,175);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pestaña.add("Ins. Estadio",pnlIns);
        pestaña.add("Bor. Estadio.",pnlBor);
        
        GridLayout pos=new GridLayout(3,2,5,5);
        pnlIns.setLayout(pos);
        pnlIns.add(lblNomEst);
        pnlIns.add(txtNomEst);
        pnlIns.add(lblAfo);
        pnlIns.add(txtAfo);
        pnlIns.add(btnIns);
        pnlIns.add(btnSali1);
        
        btnIns.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nom=txtNomEst.getText();
                    int afo=Integer.parseInt(txtAfo.getText());
                    data.insertarEstadio(nom, afo);
                    JOptionPane.showMessageDialog(null, "Estadio Insertado");
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
        
        String sentenciaSQL="SELECT * FROM estadio;";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        
        while(rs.next()){
            combo.addItem(rs.getString(1));
        }
        
        btnBor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String sentenciaSQL1="DELETE FROM estadio WHERE nom_estadio = '" + combo.getSelectedItem() +"';";
                data.ejecutarUpdate(sentenciaSQL1);
                JOptionPane.showMessageDialog(null, "Estadio borrado");
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
