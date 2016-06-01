/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liga;

import BaseDatos.DataBase;
import Principal.Inter_Principal;
import java.awt.*;
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
public class LigaCrearElim extends JFrame{
    JPanel pnlCrear=new JPanel();
    JPanel pnlElim=new JPanel();
    JButton btnCrear=new JButton("Crear Liga");
    JButton btnElim=new JButton("Eliminar Liga");
    JButton btnSali1=new JButton("Salir");
    JButton btnSali2=new JButton("Salir");
    JLabel lblNomLig=new JLabel("Nombre:");
    JLabel lblPais=new JLabel("Pais:");
    JTextField txtNomLig=new JTextField();
    JTextField txtPais=new JTextField();
    JComboBox combo=new JComboBox();
    JTabbedPane pestaña=new JTabbedPane();
    ResultSet rs;
    public LigaCrearElim() throws SQLException, ClassNotFoundException{
       DataBase data=new DataBase(); 
       this.setResizable(false);
       this.setSize(200,175);
       this.setLocationRelativeTo(null);
       
        pestaña.add("Crear Liga",pnlCrear);
        pestaña.add("Borrar Liga",pnlElim);
        
        GridLayout pos=new GridLayout(3,2);
        pnlCrear.setLayout(pos);
        pnlCrear.add(lblNomLig);
        pnlCrear.add(txtNomLig);
        pnlCrear.add(lblPais);
        pnlCrear.add(txtPais);
        pnlCrear.add(btnCrear);
        pnlCrear.add(btnSali1);
        
        btnCrear.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               String nom=txtNomLig.getText();
               String pais=txtPais.getText();
               try {
                   data.crearLiga(nom, pais);
                   JOptionPane.showMessageDialog(null, "Liga creada");
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Ha ocurrido, algún fallo");
               }
           }
            
        });
        
        btnSali1.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
              dispose(); 
           }
            
        });
        
        GridLayout pos1=new GridLayout(3,1);
        pnlElim.setLayout(pos1);
        pnlElim.add(combo);
        pnlElim.add(btnElim);
        pnlElim.add(btnSali2);
        
        String sentenciaSQL="SELECT * FROM liga";
        ResultSet rs;
        rs=data.ejecutaQuery(sentenciaSQL);
        while(rs.next()){
            combo.addItem(rs.getString(1));
        }
        
        btnElim.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               String sentenciSQL="DELETE FROM liga WHERE nom_liga = '"+ combo.getSelectedItem() +"'; ";
               data.ejecutarUpdate(sentenciSQL);
               JOptionPane.showMessageDialog(null, "Liga eliminada");
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
