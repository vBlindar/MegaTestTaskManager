package kg.mega.vblindar.mega_test.service.impl;

import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;

import kg.mega.vblindar.mega_test.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public void sendMail(CreateTaskDTO taskDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(taskDTO.getEmail());
        mailMessage.setSubject("Новая задача");
        mailMessage.setText(taskDTO.toString());
        mailSender.send(mailMessage);


    }

}
