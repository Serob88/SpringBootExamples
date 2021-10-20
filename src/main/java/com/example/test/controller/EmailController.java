package com.example.test.controller;

import com.example.test.service.EmailService;
import java.io.IOException;
import javax.mail.MessagingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @RequestMapping(value = "/sendemail")
  public String sendEmail() throws IOException, MessagingException {
    emailService.sendmail();
    return "Email sent successfully";
  }
}
