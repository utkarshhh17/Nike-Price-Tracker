package com.shreyash.backend.mail;

import com.shreyash.backend.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("$(spring.mail.username)")
    private String from;

    public boolean isIncreased(Product past, Product current){
        if (current.getPrice() > past.getPrice()){
            return true;
        } else {
            return false;
        }
    }

    public void sendMail(MailStructure mailStructure){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject(mailStructure.getSubject());
        simpleMailMessage.setText(mailStructure.getBody());
        simpleMailMessage.setTo("singhshreyash0075@gmail.com");
        javaMailSender.send(simpleMailMessage);
    }
}
