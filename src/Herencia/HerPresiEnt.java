/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author alexcampos
 */
public class HerPresiEnt {
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int sueldo;
    
    public HerPresiEnt(String dni, String nombre, String apellido, int edad){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
    
    public HerPresiEnt(String dni, String nombre, String apellido,int sueldo , int edad){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.sueldo=sueldo;
        this.edad=edad;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @return the sueldo
     */
    public int getSueldo() {
        return sueldo;
    }
}
