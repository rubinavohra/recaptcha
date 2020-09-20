package com.example.demo.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.RecaptchaResponse;


@Service("captchaService")
public class CaptchaService  {

    private final static Logger LOGGER = LoggerFactory.getLogger(CaptchaService.class);
    protected static final String RECAPTCHA_URL_TEMPLATE = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
    
    @Autowired
	RestTemplate restTemplate;

    public boolean processResponse(final String response) throws Exception {
        //securityCheck(response);
    	boolean isSuccess = false;

        final URI verifyUri = URI.create(String.format(RECAPTCHA_URL_TEMPLATE, getReCaptchaSecret(), response));
        System.out.println("=============== verifyUri ============"+verifyUri);
        try {
            final RecaptchaResponse googleResponse = restTemplate.getForObject(verifyUri, RecaptchaResponse.class);
            LOGGER.debug("Google's response: {} ", googleResponse.toString());

            isSuccess = googleResponse.isSuccess();
        } catch (Exception e) {
            throw e;
        }
        return isSuccess;
        
    }

	private Object getReCaptchaSecret() {
		// TODO Auto-generated method stub
		return "6LfLS84ZAAAAAAUNUoLtTocj4N_VoVkZhkol-Ls_";
	}
	
	/*
	 * protected String getClientIP() { final String xfHeader =
	 * request.getHeader("X-Forwarded-For"); if (xfHeader == null) { return
	 * request.getRemoteAddr(); } return xfHeader.split(",")[0]; }
	 */
}