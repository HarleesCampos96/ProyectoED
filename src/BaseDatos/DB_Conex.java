/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Establece la conexion con la Base de Datos
 * @author Harlees Campos
 */
public class DB_Conex {
    String bd;
    String usuario;
    String contraseña;
    String servidor;
    
    Connection conexion;
    
    /**
     * Cuando un usuario se conecte a la Base de Datos, tendra que tener una cuenta en la BD.
     * @param bd nombre de la Base de Datos
     * @param usuario este será de la BD
     * @param contraseña este será de la BD
     * @param servidor nombre del servidor donde esta la BD
     */
    
    public DB_Conex(String bd, String usuario, String contraseña, String servidor){
        this.bd=bd;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.servidor=servidor;
    }
    
    /**
     * 
     * @return conexion Devuelve la conexión de la BD
     * @throws SQLException excepción de la Base de Datos
     * @throws ClassNotFoundException excepción de la Base de Datos
     */
    public Connection abrirConexion() throws SQLException, ClassNotFoundException{
        boolean estado = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion =  DriverManager.getConnection(servidor + bd, usuario, contraseña);
            estado=true;
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println(ex);
            System.out.println("Error de Conexion");
        }
        return conexion;
    }
    
    /**
     * Cierra la conexion a la BD
     */
    public void cerrarConexion(){
        try{
            conexion.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
