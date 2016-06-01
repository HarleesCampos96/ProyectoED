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
public class HerJugador extends Personas{
    private int valor;
    private String Svalor;
    private int edad;
    private String Sedad;
    private String nomEqui;
    
    public HerJugador(String dni,String nomJug,String apeJug, int valor, int edad, String nomEqui){
       super(dni,nomJug,apeJug);
        this.valor=valor;
        this.edad=edad;
        this.nomEqui=nomEqui;
    }
    
     public HerJugador(String dni,String nomJug,String apeJug, String valor, String edad, String nomEqui){
         super(dni,nomJug,apeJug);
        this.Svalor=valor;
        this.Sedad=edad;
        this.nomEqui=nomEqui;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @return the nomEqui
     */
    public String getNomEqui() {
        return nomEqui;
    }

    /**
     * @return the Svalor
     */
    public String getSvalor() {
        return Svalor;
    }

    /**
     * @return the Sedad
     */
    public String getSedad() {
        return Sedad;
    }
    
}
