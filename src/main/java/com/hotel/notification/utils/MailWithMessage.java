package com.hotel.notification.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailWithMessage {
//    @Autowired
//    private JavaMailSender javaMailSenderImpl;
//
//    public void sendNewMail(String to, String subject, String body) throws MessagingException {
//
//        try {
//
//            System.out.println(to);
//            MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
//            MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
//            mailMsg.setTo("24039489@studentmail.ul.ie");
//            mailMsg.setFrom("samirchowhdry95@gmail.com");
//            mailMsg.setSubject(subject);
//            mailMsg.setText(body, true);
//
//            javaMailSenderImpl.send(mimeMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}