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
public class ArrayHerencia {
    private String id;
    private String nombre;
    
    public ArrayHerencia(String id){
        this.id=id;
    }
    
    public ArrayHerencia(String id, String nombre){
        this.nombre=nombre;
        this.id=id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
}
