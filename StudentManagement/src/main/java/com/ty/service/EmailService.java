package com.ty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ty.dto.EmailDto;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(EmailDto dto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(dto.getTo());
		message.setSubject(dto.getSubject());
		message.setText(dto.getBody());

		javaMailSender.send(message);
	}
}
