package com.example.demo.captcha;

import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CommonProperties;
import com.example.demo.model.RecaptchaResponse;
import com.example.demo.service.CaptchaService;

public class CaptchaTest {

	//@InjectMocks
	private CaptchaService captchaService;

    @Mock
	private CommonProperties commonProperties;

	@Mock
	private RestTemplateBuilder restTemplateBuilder;
	
	@Mock
	private RestTemplate restTemplate;
	
	private static final String GOOGLE_RECAPTCH_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
	 
     
    @BeforeEach
    public void before() throws Exception {
    	System.out.println("Here in Before ");
    	MockitoAnnotations.initMocks(this);
    	
    	System.out.println(" === Mocked BUilder >>"+restTemplateBuilder);
    	System.out.println(" === Mocked Common prop  >>"+commonProperties);
    	System.out.println(" === Mocked restTemplate  >>"+restTemplate);
    	
    	
    	//doNothing().when(restTemplateBuilder).setConnectTimeout(Mockito.any(Duration.class));
    	//doNothing().when(restTemplateBuilder).setReadTimeout(Mockito.any(Duration.class));
    	//when(restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(2)).build()).thenReturn(restTemplate);
    	when(restTemplateBuilder.build()).thenReturn(restTemplate);
    	
    	//when(restTemplateBuilder.build()).thenReturn(restemplate);
    	
    	
    	captchaService = new CaptchaService(restTemplateBuilder, commonProperties);
    	
    	
    	
    }
    
    private RecaptchaResponse createSuccessResponse() {
    	RecaptchaResponse res = new RecaptchaResponse();
    	res.setSuccess(Boolean.TRUE);
    	return res;
    }

    @Test
    public void testValidateCaptcha_success() throws Exception  {
        
        //when(restTemplateBuilder./*setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(2)).*/build()).thenReturn(restTemplate);
    	 // mockito mock
    	when(restTemplate.postForObject(ArgumentMatchers.eq(GOOGLE_RECAPTCH_ENDPOINT),
                ArgumentMatchers.any(Map.class), ArgumentMatchers.eq(RecaptchaResponse.class)))
        .thenReturn(createSuccessResponse());
    	
        //when(restTemplate.postForObject(Mockito.anyString(), requeMap, RecaptchaResponse.class)).thenReturn(createSuccessResponse());
    	//when(restTemplate.postForObject(Mockito.anyString(), requeMap, RecaptchaResponse.class)).thenReturn(createSuccessResponse());
        
        boolean isSuccess = captchaService.validateCaptcha(Mockito.anyString(), Mockito.anyString());
        System.out.println(" ============== Here in test case ================"+isSuccess);
        Assertions.assertTrue(isSuccess);
        
    }
    
    @Test
    public void testValidateCaptcha_failure() throws Exception  {
        
        when(restTemplate.postForObject(ArgumentMatchers.eq(GOOGLE_RECAPTCH_ENDPOINT),
                ArgumentMatchers.any(Map.class), ArgumentMatchers.eq(RecaptchaResponse.class)))
        .thenThrow(new RestClientException("Error while calling validate Recaptcha service"));

        boolean isSuccess = captchaService.validateCaptcha(Mockito.anyString(), Mockito.anyString());

        System.out.println(" ============== Here in failure test case ================"+isSuccess);
        
        Assertions.assertFalse(isSuccess);
        
    }
    
   
    
}