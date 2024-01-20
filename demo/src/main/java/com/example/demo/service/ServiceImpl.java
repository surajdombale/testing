package com.example.demo.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;


//import org.springframework.web.bind.annotation.*;

@Service
public class ServiceImpl implements Serviceint {
boolean result=false;
	@Override
	public boolean sendEmail() {
		System.out.println("i am here");
		 String user="surajdombale@gmail.com";//change accordingly  
	     String pass="rgxacuetnpktleqj";
		 String from="surajdombale@gmail.com";
		 String to="s9011112014@gmail.com";
		 String subject="suraj";
		 String msg="hi there";
		System.out.println("hee 2.5");
		Properties properties = new Properties();  
		 properties.put("mail.smtp.auth", true);
	        properties.put("mail.smtp.starttls.enable", true);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	      System.out.println("hee 2.3");
	      
	      Session session = Session.getInstance(properties,new Authenticator() {
	    	  @Override
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user,pass);
			}
			});
			System.out.println("hee 2");
//
//		 
		try {  
		 Message message= new MimeMessage(session);  
		 message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		 message.setFrom(new InternetAddress(from));  
		 message.setSubject(subject);  
		 message.setText(msg);  
			System.out.println("hee 3");

		 Transport.send(message);  
		  result=true;
		 System.out.println("Done");  
		  
		 } catch (MessagingException e) {
				System.out.println(e);

		    throw new RuntimeException(e);  
		 } 
		      
		return result;
		// TODO Auto-generated method stub
		
	}

}
