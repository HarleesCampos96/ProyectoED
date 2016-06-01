/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import BaseDatos.DataBase;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 * El usuario tendra que identificarse para acceder a la pantalla principal
 
 * @author Harlees Campos
 */
public class Inter_Login extends JFrame{
    JPanel pnl1=new JPanel();
    JPanel pnl2=new JPanel();
    JLabel lbl1=new JLabel("Liga de Futbol");
    JLabel lbl2=new JLabel("Proyecto 3º EVA");
    JLabel lbl3=new JLabel("Iniciar Sesion:");
    JLabel lbl4=new JLabel("Usuario");
    JLabel lbl5=new JLabel("Contraseña");
    JTextField txtUsu=new JTextField();
    //JTextField txtCon=new JTextField();
    JPasswordField txtCon=new JPasswordField();
    JButton btnAcc=new JButton("Acceder");
    JButton btnReg=new JButton("Registrarse");
    JFrame frReg=new JFrame();
    
    /**
     * Nos conectaremos a la Base de Datos para comprobar si el usuario y contraseña es igual a los que estan guardados en esta.
     * @throws SQLException excepción de la Base de Datos
     * @throws ClassNotFoundException excepción de la Base de Datos
     */
    public Inter_Login() throws SQLException, ClassNotFoundException{
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300,150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pnl1.setLayout(new GridLayout(3,1,5,5));
        pnl1.add(lbl1);
        pnl1.add(lbl2);
        pnl1.add(lbl3);
        
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        pnl2.setLayout(new GridLayout(3,2,3,3));
        pnl2.add(lbl4);
        pnl2.add(txtUsu);
        pnl2.add(lbl5);
        pnl2.add(txtCon);
        pnl2.add(btnAcc);
        pnl2.add(btnReg);
        
        this.add(pnl1,BorderLayout.NORTH);
        this.add(pnl2,BorderLayout.CENTER);
        
        DataBase data=new DataBase();
        
        btnAcc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String usu=txtUsu.getText();
                String con=txtCon.getText();
                ResultSet rs;
                String sentenciaSQL="SELECT * FROM USUARIOS WHERE usuario = '" + usu +"';";
                rs=data.ejecutaQuery(sentenciaSQL);
                
                try {
                    rs.next();
                    //System.out.println(rs.getString(1) +" "+rs.getString(2)+" "+rs.getString(3));
                    if(usu.equals(rs.getString(1)) && con.equals(rs.getString(2))){
                         Inter_Principal prin=new Inter_Principal(rs.getString(3));
                         dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Usuario no existe");
                }
                     
               
            }
            
        });
        
        btnReg.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Registrarse().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Inter_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        this.setVisible(true);
    }
    /**
     * 
     * @return frReg muestra por pantalla el cuadro de reegistrase
     * @throws SQLException excepción de la Base Datos
     * @throws ClassNotFoundException excepción de la Base Datos
     */
     
    public JFrame Registrarse() throws SQLException, ClassNotFoundException{
        frReg.setResizable(false);
        frReg.setLocationRelativeTo(null);
        JPanel pnReg=new JPanel();
        JButton btnCrear=new JButton("Registrar");
        JButton btnCanc=new JButton("Cancelar");
        JLabel lblUsu=new JLabel("Usuario:");
        JLabel lblCont=new JLabel("Contraseña:");
        JLabel lblCargo=new JLabel("Cargo:");
        JTextField txtUsu=new JTextField();
        JTextField txtCont=new JTextField();
        JComboBox cbCargo=new JComboBox();
        
        frReg.add(pnReg);
        pnReg.setLayout(new GridLayout(4,2));
        pnReg.add(lblUsu);
        pnReg.add(txtUsu);
        pnReg.add(lblCont);
        pnReg.add(txtCont);
        pnReg.add(lblCargo);
        pnReg.add(cbCargo);
        pnReg.add(btnCrear);
        pnReg.add(btnCanc);
        
        cbCargo.addItem("GERENTE");
        cbCargo.addItem("SECRETARIO");
        
        frReg.setSize(200,200);
        DataBase data=new DataBase();
        
        btnCrear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String usu=txtUsu.getText();
                String con=txtCont.getText();
                String car=(String) cbCargo.getSelectedItem();
                String regex="([A-Z]*)([a-z]{2})[\\.\\-_](\\d{2,})[$]";
                Pattern pat = Pattern.compile(regex);
                Matcher mat= pat.matcher(con);
                if(mat.matches()){
                    try {
                        data.crearUsuario(usu, con, car);
                        JOptionPane.showMessageDialog(null, "Usuario Registrado");
                    } catch (SQLException ex) {
                        Logger.getLogger(Inter_Login.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Inter_Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                        JOptionPane.showMessageDialog(null, "Contraseña Inconrrecta \n" +
                                "Recuerda, la contraseña debe contener al principio Mayúsculas,\n luego 2 Minúsculas, los caracteres " +
                                "(._-), luego 2 o mas números \n y terminar con el '$', ejemplo: 'ABcd_12$'");
                }
                
            }
            
        });
        
        btnCanc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frReg.dispose();            }
            
        });
        
        return frReg;
    }
}
