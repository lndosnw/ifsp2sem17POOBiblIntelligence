/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lndosnw
 */

public class SenderEmail {
    
    private String email;
    private String loginEmail;
    private String passEmail;
    
    
    private SenderEmail(){}
    
    private static SenderEmail instancia;
    public static SenderEmail getInstancia(){
        if (instancia == null){
            instancia = new SenderEmail();
        }
        return instancia;
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
                                   return new PasswordAuthentication(getLoginEmail(), getPassEmail());
                             }
                        });

            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(getEmail())); //Remetente

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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the loginEmail
     */
    public String getLoginEmail() {
        return loginEmail;
    }

    /**
     * @param loginEmail the loginEmail to set
     */
    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    /**
     * @return the passEmail
     */
    public String getPassEmail() {
        return passEmail;
    }

    /**
     * @param passEmail the passEmail to set
     */
    public void setPassEmail(String passEmail) {
        this.passEmail = passEmail;
    }
}
