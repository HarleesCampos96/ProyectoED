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
public class HerLigEst {
    private String nomLigEst;
    private String PaisAfo;
    
    public HerLigEst(String nomLigEst, String PaisAfo){
        this.nomLigEst=nomLigEst;
        this.PaisAfo=PaisAfo;
    }

    /**
     * @return the nomLigEst
     */
    public String getNomLigEst() {
        return nomLigEst;
    }
    
    /**
     * @return the PaisAfo
     */
    public String getPaisAfo() {
        return PaisAfo;
    }
}
