/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dorm.meal.plan.and.miscellaneous.options.calculator;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author stipanmadzar
 */
public class JavaEmailSender {

    static String date;
    
 
    public static void sendEmail(String recepient, String text, Label total) throws MessagingException {
        
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            
            String myAccountEmail = "yourEmailAddress@gmail.com";
            String password = "yourPassword";
            
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAccountEmail, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            
            date = getCurrentDate();
            
            message.setSubject("Your order placed at " + date);
            message.setText(text);
            Transport.send(message);
            total.setText(total.getText() + "\nEmail Sent!");   
        } 
        
        catch (AddressException ex) {
            Logger.getLogger(JavaEmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
    
}
    

