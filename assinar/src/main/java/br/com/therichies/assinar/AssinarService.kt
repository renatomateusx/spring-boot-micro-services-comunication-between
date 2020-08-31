package br.com.therichies.assinar

import br.com.therichies.assinar.dtos.SolicitacaoAssinaturaDto
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class AssinarService {

    private lateinit var producer: AssinarProducer

    fun assinar(assinatura: SolicitacaoAssinaturaDto) {
        producer.requestAssinar(assinatura)
    }
}