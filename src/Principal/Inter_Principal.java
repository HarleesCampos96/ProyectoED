/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import Entrenador.panelEnt;
import Equipo.panelEqu;
import Estadio.panelEst;
import Jugador.panelJug;
import javax.swing.*;
import Liga.panelLiga;
import Presidente.panelPre;
/**
 * Se muestra ls pestañas (paneles), donde se va a trabajar
 * @author Harlees Campos
 */
public class Inter_Principal extends JFrame{
    JTabbedPane pestaña=new JTabbedPane();
    
    /**
     * El usuario al iniciar sesion, puede tener 2 cargos
     * Usuario Gerente: Tendrá el acceso completo al programa (crear, modificar, eliminar, consultar, exportar, importar datos)
     * Usuario Secretario: Tendrá algunas restricciones en el Programa (consultar, exportar datos) 
     * @param cargo devuelve el cargo del usuario al iniciar sesión
     */
    public Inter_Principal(String cargo){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(425, 175);
        this.setLocationRelativeTo(null);
        this.setTitle("Gestion: " +cargo);
        
        panelLiga liga=new panelLiga(cargo);
        pestaña.add("Liga",liga);
        
        panelEqu equipo=new panelEqu(cargo);
        pestaña.add("Equipo",equipo);
        
        panelEst estadio=new panelEst(cargo);
        pestaña.add("Estadio",estadio);
        
        panelJug jugador=new panelJug(cargo);
        pestaña.add("Jugador",jugador);
        
        panelPre presidente=new panelPre(cargo);
        pestaña.add("Presidente",presidente);
        
        panelEnt entrenador=new panelEnt(cargo);
        pestaña.add("Entrenador",entrenador);
        
        this.add(pestaña);
        
        this.setVisible(true);
    }
}
