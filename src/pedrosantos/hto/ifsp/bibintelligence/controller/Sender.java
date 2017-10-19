/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;




/**
 *
 * @author a1520784
 */
public class Sender {
    
    private Sender() {
    }
    
    private static Sender instancia;
    public static Sender getInstancia(){
        if (instancia == null){
            instancia = new Sender();
        }
        return instancia;
    }
    
    private static final String email = "biblintelligence@gmail.com";
    private static final String loginEmail = "biblintelligence";
    private static final String passEmail = "biblintelligence.123";
    private static final String emailGateway = "biblintelligence@gmail.com";
    private static final String passGateway = "biblintelligence123";
    private static final String deviceGateway = "63987";
    
    public Boolean enviar(int destinatario, String mensagem) throws MessagingException{
        String assunto = "BiblIntelligence";
        String destinatarioEmail="",destinatarioSms="";
        Boolean resultado=false;
        Boolean rmail,rsms;
        
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

        if (enviarEmail(destinatarioEmail,assunto,mensagem)){
            rmail = true;
        }else{
            rmail = false;
        }
        if (enviarSms(destinatarioSms,mensagem)){
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
    
    public Boolean enviarSms(String destinatario,String mensagem){
        Boolean resultado = false;
        String requestUrl;
        try {
	requestUrl  = "http://smsgateway.me/api/v3/messages/send?" +
            "email=" + URLEncoder.encode(emailGateway, "UTF-8") +
            "&password=" + URLEncoder.encode(passGateway, "UTF-8") + 
            "&device=" + URLEncoder.encode(deviceGateway, "UTF-8") + 
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
    
    public Boolean enviarEmail(String destinatario,String assunto, String mensagem) throws MessagingException{
        Boolean resultado=false;
         Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "587");
            //props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            //props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 

            
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication(loginEmail, passEmail);
                             }
                        });

            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email)); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(destinatario);  
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(assunto);//Assunto
                  message.setText("BiblIntelligence informa: \n"+mensagem);
                  //Método para enviar a mensagem criada
                  Transport.send(message);
                  System.out.println("Email enviado com sucesso!");
                  resultado = true;
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      return resultado;
    }

}

