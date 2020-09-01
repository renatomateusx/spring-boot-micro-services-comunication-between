package br.com.therichies.comassinatura.service;

import br.com.therichies.comassinatura.domains.dtos.ClientDto;
import br.com.therichies.comassinatura.mail.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComunicacaoAssinatura {

    private final EmailSender mailSender;


    public void sendPlainToClient(ClientDto clientDto) {
        mailSender.sendSimpleEmail(clientDto.getEmailAddres(), "Olá " + clientDto.getFullName() + " assine um dos nossos planos", "Temos planos mensais, semestrais e anuais. Escolha um dos nossos planos e aproveite a nossa plataforma de cursos.");
    }
}
