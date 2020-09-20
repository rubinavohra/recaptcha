package com.example.demo.email;

import javax.mail.Message.RecipientType;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import static org.mockito.Mockito.*;

import com.example.demo.service.EmailService;

public class EmailTest {

	@InjectMocks
    private EmailService emailService;

    @InjectMocks
	private JavaMailSender javaMailSender;

    private MimeMessage mimeMessage;

    @Before
    public void before() throws Exception {
        mimeMessage = new MimeMessage((Session)null);
        javaMailSender = Mockito.mock(JavaMailSender.class);
        emailService = Mockito.mock(EmailService.class);
        
    }

    @Test
    public void emailTest_Success() throws Exception  {
        System.out.println(" ============== Here in test case ================"+mimeMessage);
        System.out.println(" ============== Here in test case javaMailSender================"+javaMailSender);
        System.out.println(" ============== Here in test case emailService================"+emailService);
        
        
        mimeMessage = createMimeMessage();
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        
        //boolean isSent = emailService.sendEmail();
        
        Assertions.assertDoesNotThrow(()-> emailService.sendEmail("")); // Assert whether email is sent without any exception
        Assertions.assertNotNull(mimeMessage);
		Assertions.assertEquals("subject", mimeMessage.getSubject()); //This subject is same as mocked content (without prefix)
		Assertions.assertEquals("to@domain.com", mimeMessage.getRecipients(RecipientType.TO)[0].toString());
		//System.out.println(" ============== Here in test case ================"+emailService);
    }
    
    @Test
    public void emailTest_Failure() throws Exception  {
        System.out.println(" ============== Here in second test case javaMailSender================"+javaMailSender);
        System.out.println(" ============== Here in second test case emailService================"+emailService);
        
        
        Mockito.doThrow(new MessagingException()).when(emailService).sendEmail("");
        
        Assertions.assertThrows(Exception.class, ()-> emailService.sendEmail(""));
        
    }
    
    private MimeMessage createMimeMessage() throws MessagingException {
		MimeMessage message = new MimeMessage(Session.getInstance(new Properties()));
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
		mimeMessageHelper.addTo("to@domain.com");
		mimeMessageHelper.setText("body text");
		mimeMessageHelper.setSubject("subject");
		mimeMessageHelper.getMimeMessage().saveChanges();
		return message;
	}
    
}