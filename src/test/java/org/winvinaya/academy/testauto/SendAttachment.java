package org.winvinaya.academy.testauto;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class SendAttachment{
	public void sendmail(){
		//Take current time & set format
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		SimpleDateFormat Time =new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		String mailSubject= "Automation testing || Academy Page || Student side || Page Loading time";
		String mailBody= "Automation Testing Report \nStudent side page loading time \nJob_Build_Date: "+formatter.format(date)+"\nJob_Build_Time: "+Time.format(date)+"\nPlease find the attachment";
		String testReportName= "TestReport "+formatter.format(date)+".csv";
		
		// Recipient's email ID needs to be mentioned.
		String to = "info@winvinayafoundation.org";
//		String to = "vigneshwaran.r@winvinayafoundation.org";
		String cc = "vigneshwaran.r@winvinayafoundation.org,ann.jannet@winvinayafoundation.org";

		// Sender's email ID needs to be mentioned
		String from = "winvinayajenkins@gmail.com";

		final String username = "winvinayajenkins@gmail.com";//change accordingly
		final String password = "winvinaya@123";//change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25"); 

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			InternetAddress[] iAdressArray = InternetAddress.parse(cc);
			message.setRecipients(Message.RecipientType.CC, iAdressArray);

			// Set Subject: header field
			message.setSubject(mailSubject);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText(mailBody);

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "target/TestReport.csv";//Updated on 8-Apr-22
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(testReportName);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Mail Sent successfully to "+to+" with CC "+cc);

		} catch (MessagingException e) {
			
			throw new RuntimeException(e);
			
		}
	}
}
