package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmailService;

@Controller
public class mailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendmailwithout")
	public String sendMail()
	{
		return emailService.sendMail();
	}
	
	@GetMapping("/sendmailwithattachment")
	public String sendMailWithAttachment()
	{
		return emailService.sendMailWithAttachment();
	}
}
