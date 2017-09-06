/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

/**
 *
 * @author a1520784
 */
public interface iRegistro {
     public Boolean Registrar(String nomeReg, String tipoReg, String key);
     public Boolean Registrar(String nomeReg, String key);
     public Boolean Registrar(String key);
}
