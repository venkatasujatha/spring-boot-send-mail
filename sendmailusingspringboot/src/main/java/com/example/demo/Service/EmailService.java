package com.example.demo.Service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;

	public String sendMail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("bsujatha641@gmail.com");
		mailMessage.setTo("valluru.1sujatha@gmail.com");
		mailMessage.setSubject("Test Subject");
		mailMessage.setText("Test Body");

		mailSender.send(mailMessage);

		return "mail sent successfully" + mailMessage.getSentDate();
	}

	public String sendMailWithAttachment() {
		try
		{
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, true);
		messageHelper.setFrom("bsujatha641@gmail.com");
		messageHelper.setTo("valluru.1sujatha@gmail.com");
		messageHelper.setText("Test Body");
		messageHelper.setSubject("Test Subject");
		File file=new File("/home/tectoro/Downloads");
		messageHelper.addAttachment(file.getName(), file);
		mailSender.send(mimeMessage);
		
		return "mail send successfully";
		}
		catch (Exception e) {
			return "mail send failed";
		}
	}

}
