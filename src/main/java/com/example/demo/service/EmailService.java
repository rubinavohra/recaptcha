package com.example.demo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service("emailService")
public class EmailService  {

    private static final String NOREPLY_ADDRESS = "noreply@test.com";

    @Autowired
    private JavaMailSender emailSender;


    
    public void sendEmail() throws MessagingException {
    	
    	//boolean sentStatus = false;
    	try {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(NOREPLY_ADDRESS);
        helper.setTo("vohra.rubina@gmail.com");
        helper.setSubject("WITH PREFIX" + " TEST ");
        helper.setText("Actual content here ..........", true);
        //helper.addInline("attachment.png", resourceFile);
        emailSender.send(message);
        //sentStatus = true;
    	} catch (Exception e) {
    		//sentStatus = false;
		}
    	//return sentStatus;
    }
   
}
