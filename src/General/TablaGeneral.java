/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import BaseDatos.DataBase;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexcampos
 */
public class TablaGeneral extends JFrame{
    JTable Tab=new JTable();
    JScrollPane sc=new JScrollPane(Tab);
    ResultSet rs;
    String sentenciaSQL;
    DefaultTableModel modelo=new DefaultTableModel();
    
    public TablaGeneral(String tabBD) throws SQLException, ClassNotFoundException{
        this.add(sc,BorderLayout.CENTER);
        this.setTitle("Tabla de "+ tabBD);
        Tab.setModel(modelo);
        DataBase data=new DataBase();
        sentenciaSQL = "SELECT * FROM "+ tabBD +";";
        int col=data.devolverStringResultSet(sentenciaSQL).length;
        rs=data.ejecutaQuery(sentenciaSQL);
        for(int i=0; i<col;i++){
            modelo.addColumn(data.devolverStringResultSet(sentenciaSQL)[i]);
        }
        
        while(rs.next()){
            Object[] ob=new Object[col];
            for(int x=0;x<col;x++){
                ob[x]=rs.getString(x+1);
            }
            modelo.addRow(ob);
            ob=null;
        }
        rs.close();
        
        this.setSize(400,200);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
