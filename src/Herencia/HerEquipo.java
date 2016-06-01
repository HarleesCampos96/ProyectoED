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
public class HerEquipo {
    private String nombre;
    private String localidad;
    private String nomEst;
    private int presu;
    private String nomLiga;
    private String dniEntre;
    private String dniPresi;
    
    public HerEquipo(String nombre, String localidad, String nomEst, int presu, String nomLiga, String dniEntre, String dniPresi){
        this.nombre=nombre;
        this.localidad=localidad;
        this.nomEst=nomEst;
        this.presu=presu;
        this.nomLiga=nomLiga;
        this.dniEntre=dniEntre;
        this.dniPresi=dniPresi;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @return the nomEst
     */
    public String getNomEst() {
        return nomEst;
    }

    /**
     * @return the presu
     */
    public int getPresu() {
        return presu;
    }

    /**
     * @return the nomLiga
     */
    public String getNomLiga() {
        return nomLiga;
    }

    /**
     * @return the dniEntre
     */
    public String getDniEntre() {
        return dniEntre;
    }

    /**
     * @return the dniPresi
     */
    public String getDniPresi() {
        return dniPresi;
    }
    
}
