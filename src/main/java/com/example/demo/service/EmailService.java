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


    
    public void sendEmail(String buildEmailForm) throws MessagingException {
    	
    	//boolean sentStatus = false;
    	try {
    	System.out.println("Here in service");
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
    		throw e;
		}
    	//return sentStatus;
    }
   
}
