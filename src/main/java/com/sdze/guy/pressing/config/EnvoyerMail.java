package com.sdze.guy.pressing.config;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvoyerMail {
	
	public String username = "guylarochefeu@gmail.com";
	public String password = "laroche22";
	
	public void envoyer() {
		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("love2lespoir@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("guylarochefeu@gmail.com"));
			message.setSubject("TEST JAVA MAIL");
			message.setText("Bonjour ceci est mon premier gmail");
			
			Transport.send(message);
			System.out.println("le message a ete envoyer avec success");
		}catch (MessagingException e) {
			System.out.println("-------------------------  l envoi a echouer  -------------------------------");
			throw new RuntimeException(e);
		}
		
		
	}

}
