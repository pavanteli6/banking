//package com.banking.auth.utilities;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.Transport;
//import javax.mail.internet.*;
//import org.springframework.stereotype.Service;
//
//import com.mysql.cj.Session;
//
//@Service
//public class MailService {
//
//	static final String FROM = "pavanteli6@gmail.com";
//
//	static final String FROMNAME = "PAVAN TELI";
//	static final String SMTP_USERNAME = "pavanteli6@gmail.com";
//	static final String SMTP_PASSWORD = "Pavan@123";
//	static final String HOST = "smtp.gmail.com";
//	static final String PORT = "587";
//	static final String SUBJECT = "Banking OTP";
//
//	public boolean sendMail(String emailId, int otpValue) {
//		try {
//			Properties props = System.getProperties();
//			props.put("mail.transport.protocol", "smtp");
//			props.put("mail.smtp.host", "host");
//			props.put("mail.smtp.port", "port");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.auth", "true");
//			
//			Session session = Session.getDefaultInstance(props);
//			
//			MimeMessage msg = new MimeMessage(session);
//			
//			msg.setFrom(new InternetAddress(FROM,FROMNAME));
//			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
//			msg.setSubject(SUBJECT);
//			msg.setContent("Please enter OTP to verify Email"+otpValue,"text/html");
//			
//			Transport transport = session.getTransport();
//			transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
//			transport.sendMessage(msg, msg.getAllRecipients());
//			return true;
//		}
//		catch(Exception ex){
//			return false;
//			
//		}
//	}
//
//}
