/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lndosnw
 */
public class Registro implements iRegistro{
     private String nomeRegistro = "";
     private String tipoRegistro = "";
     private Date dataRegistro = null;
     private Boolean registrado = false;

    private static Registro instancia;
    public static Registro getInstancia(){
        if (instancia == null){
            instancia = new Registro();
        }
        return instancia;
    }
     
     
     
    /**
     * @return the nomeRegistro
     */
    public String getNomeRegistro() {
        return nomeRegistro;
    }

    /**
     * @return the tipoRegistro
     */
    public String getTipoRegistro() {
        return tipoRegistro;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }
    
    public String getDataRegistroStr(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = formato.format(dataRegistro);
        return data;
    }
    
    public Boolean Registrar(String nomeReg, String tipoReg, String key){
        if(key.equals("12345")){
            this.nomeRegistro = nomeReg;
            this.tipoRegistro = tipoReg;
            this.dataRegistro = new Date();
            this.registrado = true;
            return true;
        }else if (!registrado){
            this.nomeRegistro = "DEMO";
            this.tipoRegistro = "DEMO";
            return false;
        }else{
            return false;
        }
    }
    
    public Boolean Registrar(String nomeReg, String key){
        if(key.equals("66666")){
            this.nomeRegistro = nomeReg;
            this.tipoRegistro = "Desenvolvedor";
            this.dataRegistro = new Date();
            this.registrado = true;
            return true;
        }else if (!registrado){
            this.nomeRegistro = "DEMO";
            this.tipoRegistro = "DEMO";
            return false;
        }else{
            return false;
        }
    }
    public Boolean Registrar(String key){
        if(key.equals("00000")){
            this.nomeRegistro = "Teste";
            this.tipoRegistro = "Copia de Avaliação";
            this.dataRegistro = new Date();
            this.registrado = true;
            return true;
        }else if (!registrado){
            this.nomeRegistro = "DEMO";
            this.tipoRegistro = "DEMO";
            return false;
        }else{
            return false;
        }
    }

}
