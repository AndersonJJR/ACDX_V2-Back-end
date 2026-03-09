package com.anderson.meu_projeto.service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.anderson.meu_projeto.exception.CustomException;
import com.anderson.meu_projeto.model.NotificationEmail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {
    
    private final JavaMailSender javaMailSender;
    private final MailContentBuilder mailContentBuilder;
    
    @Async
    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("andersonapiservice@email.com");
            messageHelper.setTo(notificationEmail.recipient());
            messageHelper.setSubject(notificationEmail.subject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.body()), true);
        };
        try{
            javaMailSender.send(mimeMessagePreparator);
            log.info("Email de ativação enviado!");
        } catch (MailException e){
            log.error("Uma exceção ocorreu ao mandar o email" , e);
            throw new CustomException("Uma exceção ocorreu ao enviar um email para - " + notificationEmail.recipient(), e);
        }
    }
}
