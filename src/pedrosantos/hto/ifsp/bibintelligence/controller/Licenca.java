/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.util.Date;

/**
 *
 * @author lndosnw
 */
public class Licenca extends Registro{
    private Boolean limitada;
    private Date validadeLicenca;
    private String key ="85201";

    private Licenca() {
        super();
    }

    
    private static Licenca instancia;
    public static Licenca getInstancia(){
        if (instancia == null){
            instancia = new Licenca();
        }
        return instancia;
    }
    
    
    /**
     * @return the limitada
     */
    public Boolean getLimitada() {
        return limitada;
    }

    /**
     * @return the validadeLicenca
     */
    public Date getValidadeLicenca() {
        return validadeLicenca;
    }
    
    public Boolean verificaLicenca(){
        if((this.getNomeRegistro().equals("")) || (this.getNomeRegistro().equals("DEMO")) ){
            return false;
        }else{
            return true;
        }
    }
    
    public Boolean carregaLicenca(){
        Boolean resultado = false;
        if (verificaLicenca() == false){
            if (this.Registrar(key)){
                resultado = true;
            }
        }
        return resultado;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
}
