/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import BaseDatos.DataBase;
import Herencia.HerEquipo;
import Herencia.HerJugador;
import Herencia.HerLigEst;
import Herencia.HerPresiEnt;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
public class ExportGeneral extends JFrame{
    JPanel pnl1=new JPanel();
    JPanel pnl2=new JPanel();
    JLabel lblExp=new JLabel();
    JFileChooser fcExp=new  JFileChooser();
    JButton btnGuardar=new JButton("Guardar");
    JButton btnSalir=new JButton("Salir");
    JScrollPane sc=new JScrollPane();
    JTextArea taExp=new JTextArea();
    String texto;
    String sentenciaSQL;
    ResultSet rs;
    ArrayList<HerLigEst> lista=new ArrayList<>();
    ArrayList<HerLigEst> lista1=new ArrayList<>();
    ArrayList<HerPresiEnt> lista2=new ArrayList<>();
    ArrayList<HerPresiEnt> lista3=new ArrayList<>();
    ArrayList<HerEquipo> lista4=new ArrayList<>();
    ArrayList<HerJugador> lista5=new ArrayList<>();
    
    public ExportGeneral(String tabBD) throws SQLException, ClassNotFoundException{
        
        DataBase data=new DataBase();
        this.add(pnl1,BorderLayout.NORTH);
        this.add(sc,BorderLayout.CENTER);
        this.add(pnl2,BorderLayout.SOUTH);
        
        lblExp.setText("Exportar " + tabBD);
        pnl1.add(lblExp);
        
        taExp.setLineWrap(true);
        taExp.setWrapStyleWord(true);
        sc.setViewportView(taExp);
        
        GridLayout pos=new GridLayout(1,2);
        pnl2.setLayout(pos);
        pnl2.add(btnGuardar);
        pnl2.add(btnSalir);
        
        int i=0;
        sentenciaSQL="SELECT * FROM " + tabBD + "; ";
        rs=data.ejecutaQuery(sentenciaSQL);
        while(rs.next()){
            if(tabBD.equals("liga")){
                HerLigEst herLigEst=new HerLigEst(rs.getString(1), rs.getString(2));
                lista.add(i, herLigEst);
            }
            else if(tabBD.equals("estadio")){
                HerLigEst herLigEst=new HerLigEst(rs.getString(1), rs.getString(2));
                lista1.add(i, herLigEst);
            }
            else if(tabBD.equals("presidente")){
                HerPresiEnt herPresiEnt=new HerPresiEnt(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                lista2.add(i, herPresiEnt);
            }
            else if(tabBD.equals("entrenador")){
                HerPresiEnt herPresiEnt=new HerPresiEnt(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                lista3.add(i, herPresiEnt);
            }
            else if(tabBD.equals("equipo")){
                HerEquipo herEquipo=new HerEquipo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
                lista4.add(i, herEquipo);
            }
            else if(tabBD.equals("jugador")){
                HerJugador herJugador=new HerJugador(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
                lista5.add(i, herJugador);
            }
            i++;
        }
        
        
        if(tabBD.equals("liga")){
            int x=0;
            while(x<lista.size()){
                texto=lista.get(x).getNomLigEst() + ";\t" + lista.get(x).getPaisAfo();
                taExp.append(texto);
                taExp.append(System.getProperty("line.separator"));
                x++;
            }
        }
        else if(tabBD.equals("estadio")){
            int x=0;
            while(x<lista1.size()){
                texto=lista1.get(x).getNomLigEst() + ";\t" + lista1.get(x).getPaisAfo();
                taExp.append(texto);
                taExp.append(System.getProperty("line.separator"));
                x++;
            }
        }
        else if(tabBD.equals("presidente")){
            int x=0;
            while(x<lista2.size()){
                texto=lista2.get(x).getDni() + ";\t" + lista2.get(x).getNombre() + ";\t" + lista2.get(x).getApellido()+ ";\t" + lista2.get(x).getEdad();
                taExp.append(texto);
                taExp.append(System.getProperty("line.separator"));
                x++;
            }
        }
        
        else if(tabBD.equals("entrenador")){
            int x=0;
            while(x<lista3.size()){
                texto=lista3.get(x).getDni() + ";\t" + lista3.get(x).getNombre() + ";\t" + lista3.get(x).getApellido()+ ";\t"
                        + lista3.get(x).getSueldo() + ";\t" + lista3.get(x).getEdad();
                taExp.append(texto);
                taExp.append(System.getProperty("line.separator"));
                x++;
            }
        }
        
        else if(tabBD.equals("equipo")){
            int x=0;
            while(x<lista4.size()){
                texto=lista4.get(x).getNombre() + ";\t" + lista4.get(x).getLocalidad() + ";\t" + lista4.get(x).getNomEst() + ";\t" +
                        String.valueOf(lista4.get(x).getPresu())+ ";\t" + lista4.get(x).getNomLiga() + ";\t" + lista4.get(x).getDniEntre()
                        + ";\t" + lista4.get(x).getDniPresi();
                taExp.append(texto);
                taExp.append(System.getProperty("line.separator"));
                x++;
            }
        }
        
        else if(tabBD.equals("jugador")){
            int x=0;
            while(x<lista5.size()){
                texto=lista5.get(x).getDni() + ";\t" + lista5.get(x).getNombre() + ";\t" + lista5.get(x).getApellido() + ";\t" +
                        String.valueOf(lista5.get(x).getValor()) + ";\t" + String.valueOf(lista5.get(x).getEdad()) + ";\t" + lista5.get(x).getNomEqui();
                taExp.append(texto);
                taExp.append(System.getProperty("line.separator"));
                x++;
            }
        }
        
        btnGuardar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre="";
                fcExp.showSaveDialog(sc);
                File guardar = fcExp.getSelectedFile();
                
                if(guardar != null){
                nombre=fcExp.getSelectedFile().getName();
                    System.out.println(nombre);
                    try {
                        FileWriter fw=new FileWriter(guardar +".csv");
                        fw.write(taExp.getText());
                        fw.close();
                        JOptionPane.showMessageDialog(null, "El archivo se ha guardado");
                    } catch (IOException ex) {
                        Logger.getLogger(ExportGeneral.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
                
            }
            
        });
        
        btnSalir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    } 
    
}
