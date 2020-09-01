package br.com.therichies.comassinatura.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailSender {

    private final JavaMailSender emailsender;

    public void sendSimpleEmail(String to, String subject, String body) {
        final var message = new SimpleMailMessage();
        message.setFrom("leonardo.amaral.sousa@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        emailsender.send(message);
    }
}
