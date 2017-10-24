/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author lndosnw
 */
public class SenderSMS {
    
    private SenderSMS(){}
    
    private static SenderSMS instancia;
    public static SenderSMS getInstancia(){
        if (instancia == null){
            instancia = new SenderSMS();
        }
        return instancia;
    }
    
    private String emailGateway;
    private String passGateway;
    private String deviceGateway;
    
        
    public Boolean enviarSms(String destinatario,String mensagem){
        Boolean resultado = false;
        String requestUrl;
        try {
	requestUrl  = "http://smsgateway.me/api/v3/messages/send?" +
            "email=" + URLEncoder.encode(getEmailGateway(), "UTF-8") +
            "&password=" + URLEncoder.encode(getPassGateway(), "UTF-8") + 
            "&device=" + URLEncoder.encode(getDeviceGateway(), "UTF-8") + 
            "&number=" + URLEncoder.encode(destinatario, "UTF-8") +
            "&message=" + URLEncoder.encode("BiblIntelligence informa: "+mensagem, "UTF-8");
			
		  URL url = new URL(requestUrl);		  
		  HttpURLConnection uc = (HttpURLConnection)url.openConnection();
		  
		  System.out.println(uc.getResponseMessage());

		  uc.disconnect();

		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}        
        return resultado;
    }

    /**
     * @return the emailGateway
     */
    public String getEmailGateway() {
        return emailGateway;
    }

    /**
     * @param emailGateway the emailGateway to set
     */
    public void setEmailGateway(String emailGateway) {
        this.emailGateway = emailGateway;
    }

    /**
     * @return the passGateway
     */
    public String getPassGateway() {
        return passGateway;
    }

    /**
     * @param passGateway the passGateway to set
     */
    public void setPassGateway(String passGateway) {
        this.passGateway = passGateway;
    }

    /**
     * @return the deviceGateway
     */
    public String getDeviceGateway() {
        return deviceGateway;
    }

    /**
     * @param deviceGateway the deviceGateway to set
     */
    public void setDeviceGateway(String deviceGateway) {
        this.deviceGateway = deviceGateway;
    }
}
