package com.thejoa.boot008.util9_sms;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@Component
public class SmsService {
	
	@Value("${sms_key}")
	private String sms_key;
	
	@Value("${sms_secret}")
	private String sms_secret;
	
	public String phoneNumberCheck(String to) throws CoolsmsException {
		String result="";
		
		Random rand = new Random();
		for(int i=0; i<6; i++) {result += Integer.toString(rand.nextInt(10));}
		
		Message message = new Message(sms_key,sms_secret);
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", to); // 수신번호
	    params.put("from", to); // 발신번호
	    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
	    params.put("text", "인증번호 ["+result+"]입니다."); // 문자내용    
	    message.send(params);
		return result;
	}
}
