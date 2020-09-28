package com.example.demo.service;

import java.net.URI;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CommonProperties;
import com.example.demo.model.RecaptchaResponse;


@Service("captchaService")
public class CaptchaService  {

    private final static Logger LOGGER = LoggerFactory.getLogger(CaptchaService.class);
    private static final String GOOGLE_RECAPTCH_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify"; //?secret=%s&response=%s";
    private static final String RECAPTCHA_URL_TEMPLATE = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
    
    private static final String CAPTCHA_SECRET_KEY = "captcha.emerge.secret";
    private static final String CAPTCHA_SECRET_KEY_DEFAULT = "default";
    
   
	private RestTemplate restTemplate;
	private CommonProperties commonProperties;
    
    public CaptchaService (RestTemplateBuilder restTemplateBuilder, CommonProperties commonProperties) {
		//this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(2)).build();
    	this.restTemplate = restTemplateBuilder.build();
		this.commonProperties = commonProperties;
	}
    
    public boolean validateCaptcha(String response, String clientIp) {
    	try {
	    	String captchasecret = commonProperties.get(CAPTCHA_SECRET_KEY,CAPTCHA_SECRET_KEY_DEFAULT);
	    	MultiValueMap<String, String> requeMap = new LinkedMultiValueMap<>();
	    	requeMap.add("secret", captchasecret);
	    	requeMap.add("response", response);
	    	requeMap.add("clientip", clientIp);
	    	RecaptchaResponse googleResponse = restTemplate.postForObject(GOOGLE_RECAPTCH_ENDPOINT, requeMap, RecaptchaResponse.class);
	    	if(googleResponse == null) {
	    		return false;
	    	}
	    	return googleResponse.isSuccess();
    	} catch (RestClientException re) {
    		System.out.println("============Error from service ===============");
			return false;
		}
    	
    	
    }
    
   

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