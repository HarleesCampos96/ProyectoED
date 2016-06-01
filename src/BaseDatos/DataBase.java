/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.DriverManager;

/**
 * Aqui se realizara la consultas, los updates, insetar y elimnar las filas de las tablas de la BD 
 * @author Harlees Campos
 */
public class DataBase {
    
    DB_Conex modConex=new DB_Conex("liga-completa","gerente","ABcd_12$","jdbc:mysql://localhost/");
    Connection conexion;

    /**
     * Recibe la conexion de la Base de Datos
     * @throws SQLException excepción de la Base de Datos
     * @throws ClassNotFoundException excepción de la Base de Datos
     */
    public DataBase() throws SQLException, ClassNotFoundException {
        this.conexion = modConex.abrirConexion();
    }
    
    /**
     * @param sentenciaSQL se ejecutara en la BD
     * @return n devuelve numeros de Updates
     */
    public int ejecutarUpdate(String sentenciaSQL){
        int n=0;
        try{
            Statement st=conexion.createStatement();
            n=st.executeUpdate(sentenciaSQL);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return n;
    }
    
    /**
     * Realiza las consultas a las BD
     * @param sentenciaSQL se ejecutara en la BD
     * @return rs devuelve las filas de la Tabla
     */
    public ResultSet ejecutaQuery(String sentenciaSQL){
        ResultSet rs=null;
        
        try{
            Statement st=conexion.createStatement();
            rs=st.executeQuery(sentenciaSQL);
        }
        catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    /**
     * Devuelve los nombres de las columnas de las Tablas de la BD
     * @param sentenciaSQL se ejecutara en la BD
     * @return colummnas devuelve un array de String con las colummnas
     * @throws SQLException excepción de la Base de Datos
     */
    public String[] devolverStringResultSet(String sentenciaSQL) throws SQLException{
        String cadena="";
        ResultSet rs=null;
        rs= ejecutaQuery(sentenciaSQL);
        
        //Se obtiene los metadatos de la consulta,
        //con ellos podemo obtener el numero de colummnas y el nombre de las mismas
        ResultSetMetaData metaDatos = rs.getMetaData();
        //obtenemos el numero de consultas
        int numColumnas = metaDatos.getColumnCount();
        //Metemos en el array el nombre de las etiquetas
        //  OJO: Empiezan desde el 1
        String[] columnas = new String[numColumnas];
        for(int i=0; i<numColumnas; i++){
            columnas[i]=metaDatos.getColumnLabel(i+1);
        }
        return columnas;
    }
    
    /**
     * Crear Usuarios en la BD
     * @param usuario
     * @param contrasena
     * @param cargo
     * @throws SQLException
     * @throws ClassNotFoundException excepción de la Base de Datos
     */
    public void crearUsuario(String usuario, String contrasena, String cargo) throws SQLException, ClassNotFoundException{
             CallableStatement cs;
             cs=conexion.prepareCall("{call AgregarUsuarios(?,?,?)}");
             cs.setString(1, usuario);
             cs.setString(2, contrasena);
             cs.setString(3, cargo);
             cs.execute();
         
    }
    
    /**
     * Crea ligas en la BD
     * @param nomLiga
     * @param pais
     * @throws SQLException excepción de la Base de Datos
     */
    public void crearLiga(String nomLiga, String pais) throws SQLException{
             CallableStatement cs;
             cs=conexion.prepareCall("{call CrearLiga(?,?)}");
             cs.setString(1, nomLiga);
             cs.setString(2, pais);
             cs.execute();
    }
    
    /**
     * Insertar estadios en la BD
     * @param nomEst
     * @param aforo
     * @throws SQLException excepción de la Base de Datos
     */
    public void insertarEstadio(String nomEst, int aforo) throws SQLException{
             CallableStatement cs;
             cs=conexion.prepareCall("{call InsertarEstadio(?,?)}");
             cs.setString(1, nomEst);
             cs.setInt(2, aforo);
             cs.execute();
    }
    
    /**
     * Inserta entrenadores en la BD
     * @param dni
     * @param nomEnt
     * @param apeEnt
     * @param sueldo
     * @param edad
     * @throws SQLException excepción de la Base de Datos
     */
    public void insertarEntrenador(String dni, String nomEnt, String apeEnt, int sueldo, int edad) throws SQLException{
             CallableStatement cs;
             cs=conexion.prepareCall("{call InsertarEntrenador(?,?,?,?,?)}");
             cs.setString(1,dni);
             cs.setString(2,nomEnt);
             cs.setString(3,apeEnt);
             cs.setInt(4,sueldo);
             cs.setInt(5,edad);
             cs.execute();
             
    }
    
    /**
     * Inserta presidentes en la BD
     * @param dni
     * @param nomPre
     * @param apePre
     * @param edad
     * @throws SQLException excepción de la Base de Datos
     */
    public void insertarPresidente(String dni, String nomPre, String apePre, int edad) throws SQLException{
             CallableStatement cs;
             cs=conexion.prepareCall("{call InsertarPresidente(?,?,?,?)}");
             cs.setString(1, dni);
             cs.setString(2, nomPre);
             cs.setString(3, apePre);
             cs.setInt(4, edad);
             cs.execute();
    }
    
    /**
     * Inserta equipos en la BD
     * @param nomEqui
     * @param localidad
     * @param nomEst
     * @param presupuesto
     * @param nomLiga
     * @param dniEnt
     * @param dniPre
     * @throws SQLException excepción de la Base de Datos
     */
    public void insertarEquipo(String nomEqui, String localidad, String nomEst, int presupuesto, String nomLiga, String dniEnt, String dniPre) throws SQLException{
            CallableStatement cs;
            cs=conexion.prepareCall("{call InsertarEquipo(?,?,?,?,?,?,?)}");
            cs.setString(1, nomEqui);
            cs.setString(2, localidad);
            cs.setString(3, nomEst);
            cs.setInt(4, presupuesto);
            cs.setString(5, nomLiga);
            cs.setString(6, dniEnt);
            cs.setString(7, dniPre);
            cs.execute();
    }
    
    /**
     * Inserta jugadores en la BD
     * @param dni
     * @param nomJug
     * @param apeJug
     * @param valor
     * @param edad
     * @param nomEqu
     * @throws SQLException excepción de la Base de Datos
     */
    public void insertarJugador(String dni, String nomJug, String apeJug, int valor, int edad, String nomEqu) throws SQLException{
        try{
        CallableStatement cs;
        cs=conexion.prepareCall("{call InsertarJugador(?,?,?,?,?,?)}");
        cs.setString(1, dni);
        cs.setString(2, nomJug);
        cs.setString(3, apeJug);
        cs.setInt(4, valor);
        cs.setInt(5, edad);
        cs.setString(6, nomEqu);
        cs.execute();
        }
        catch(MySQLIntegrityConstraintViolationException a){
            
        }
    }
    
    /**
     * Modificar jugadores de un fila de la tabla de la BD
     * @param id
     * @param nombre
     * @param apellido
     * @param valor
     * @param edad
     * @param equipo 
     */
    public void modificarJugador(String id, String nombre, String apellido,int valor, int edad,  String equipo){
        try{
             PreparedStatement updateDatos = conexion.prepareStatement(
         "UPDATE jugador SET nom_juga = ?, ape_juga = ?, valor = ?, edad = ?, nom_equi = ? WHERE dni = ?");
            updateDatos.setString(1, nombre);
            updateDatos.setString(2, apellido);
            updateDatos.setInt(3, valor);
            updateDatos.setInt(4, edad);
            updateDatos.setString(5, equipo);
            updateDatos.setString(6, id);
            updateDatos.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }    
        }
    
    /**
     * Modificar equipos de un fila de la tabla de la BD
     * @param nombre
     * @param localidad
     * @param nomEst
     * @param presu
     * @param nomLiga
     * @param dniEntre
     * @param dniPresi
     * @throws SQLException 
     */
    public void modificarEquipo(String nombre, String localidad, String nomEst, int presu, String nomLiga, String dniEntre, String dniPresi) throws SQLException{
            PreparedStatement updateDATOS = conexion.prepareStatement(
          "UPDATE equipo SET localidad = ?, nom_estadio = ?, presupuesto = ?, nom_liga = ?, dni_entre = ?, dni_presi = ? WHERE nom_equi = ?");
            updateDATOS.setString(1, localidad);
            updateDATOS.setString(2, nomEst);
            updateDATOS.setInt(3, presu);
            updateDATOS.setString(4, nomLiga);
            updateDATOS.setString(5, dniEntre);
            updateDATOS.setString(6, dniPresi);
            updateDATOS.setString(7, nombre);
            updateDATOS.executeUpdate();
            
    }
    
}
