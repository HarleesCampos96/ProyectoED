/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import BaseDatos.DataBase;
import Herencia.HerJugador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexcampos
 */
public class JugImp {
    
    public JugImp(File file) throws FileNotFoundException, SQLException, ClassNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(file));
        DataBase data=new DataBase();
        ArrayList<HerJugador> list=new ArrayList<>();
        String linea;
        int i=0;
        
        while((linea=br.readLine()) != null){
            String[] aux=new String[6];
            //int[] num=new int[2];
            aux = linea.split(";");
            //num = Integer.parseInt(linea.split(";"));
            
            HerJugador jugador = new HerJugador(aux[0],aux[1],aux[2],aux[3],aux[4],aux[5]);
            list.add(i,jugador);
            System.out.println(aux[0]+" " +aux[1]+" "+aux[2]+" "+aux[3]+" "+aux[4]+" "+aux[5]);
            i++;
        }
        
        int x=0;
        while(x<list.size()){
            data.insertarJugador(list.get(x).getDni(), list.get(x).getNombre(), list.get(x).getApellido(), Integer.parseInt(list.get(x).getSvalor())
                    , Integer.parseInt(list.get(x).getSedad()), list.get(x).getNomEqui());
            x++;
        }
        
    }
}
