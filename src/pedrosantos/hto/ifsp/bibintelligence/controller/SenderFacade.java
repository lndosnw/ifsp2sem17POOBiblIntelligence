/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;




/**
 *
 * @author a1520784
 */
public class SenderFacade {
    
    private SenderFacade() {
    }
    
    private static SenderFacade instancia;
    public static SenderFacade getInstancia(){
        if (instancia == null){
            instancia = new SenderFacade();
        }
        return instancia;
    }
    
    private static final String email = "biblintelligence@gmail.com";
    private static final String loginEmail = "biblintelligence";
    private static final String passEmail = "biblintelligence.123";
    private static final String emailGateway = "biblintelligence@gmail.com";
    private static final String passGateway = "biblintelligence123";
    private static final String deviceGateway = "63987";
    
    public void configurarSenders(){
        SenderEmail senderEmail = SenderEmail.getInstancia();
        senderEmail.setEmail(email);
        senderEmail.setLoginEmail(loginEmail);
        senderEmail.setPassEmail(passEmail);
        SenderSMS senderSMS = SenderSMS.getInstancia();
        senderSMS.setEmailGateway(emailGateway);
        senderSMS.setPassGateway(passGateway);
        senderSMS.setDeviceGateway(deviceGateway);
    }
    
    public Boolean enviar(int destinatario, String mensagem) throws MessagingException{
        String assunto = "BiblIntelligence";
        String destinatarioEmail="",destinatarioSms="";
        Boolean resultado=false;
        Boolean rmail,rsms;
        
        configurarSenders();
        
        try {
            //Conexao.finalizaUso();
                while(Conexao.getResultSet("Select * from usuarios where idUsuario = '"+ destinatario +"';").next()) {
                    destinatarioEmail = Conexao.getRsString("email");
                    destinatarioSms ="+55"+ Conexao.getRsString("telefone");
                }
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally

        if ( SenderEmail.getInstancia().enviarEmail(destinatarioEmail,assunto,mensagem)){
            rmail = true;
        }else{
            rmail = false;
        }
        if ( SenderSMS.getInstancia().enviarSms(destinatarioSms,mensagem)){
            rsms = true;
        }else{
            rsms = false;
        }
        if (rmail && rsms){
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }

}

