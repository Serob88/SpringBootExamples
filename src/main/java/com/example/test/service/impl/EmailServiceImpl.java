package com.example.test.service.impl;

import com.example.test.service.EmailService;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  public void sendmail() {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("your.email@gmail.com", "your password");
      }
    });
    Message msg = new MimeMessage(session);
    try {
      msg.setFrom(new InternetAddress("Serob.Kirakosyan.88@gmail.com", false));

      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Serob.Kirakosyan.88@gmail.com"));
      msg.setSubject("Test point email");
      msg.setContent("Test point email", "text/html");
      msg.setSentDate(new Date());
      Transport.send(msg);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
