package com.mettucovid.services;

import java.util.Properties;

import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class EmailServices {

	public static void sendMail(String userEmail, String userName, String userPassword)  {
		

		final String emailid = "mettucenter@gmail.com";
		final String pwd = "MettuCovid19";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailid, pwd);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailid));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			

			message.setSubject("Mettu Center Help");
			message.setText("Hi " + userName 
					+ ",\n\nPlease find your log in credentials below.\n\nUserID: "
					+ userEmail + "\nPassword: " + userPassword
					+ "\n\nPlease mail us, if you need any support from us.\n\nThank you\nTeam - MettuCovid Project");

			/*
			 * MimeBodyPart imagePart = new MimeBodyPart();
			 * imagePart.attachFile("resources/teapot.jpg");
			 * imagePart.setContentID("<" + cid + ">");
			 * imagePart.setDisposition(MimeBodyPart.INLINE);
			 * content.addBodyPart(imagePart);
			 */

			Transport.send(message);

			System.out.println("Success");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
