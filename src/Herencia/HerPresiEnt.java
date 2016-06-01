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
public class HerPresiEnt extends Personas{
    private int edad;
    private int sueldo;
    
    public HerPresiEnt(String dni, String nombre, String apellido, int edad){
        super(dni,nombre,apellido);
        this.edad=edad;
    }
    
    public HerPresiEnt(String dni, String nombre, String apellido,int sueldo , int edad){
        super(dni,nombre,apellido);
        this.sueldo=sueldo;
        this.edad=edad;
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
