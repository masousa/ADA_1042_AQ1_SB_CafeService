package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.factory.RealizarPagamentoService;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Compra;
import tech.ada.bootcamp.arquitetura.cafeservice.model.StatusCompra;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.TipoPagamento;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RealizarPagamentoCreditoService implements RealizarPagamentoService {

    @Override
    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.CREDITO;
    }

    @Override
    public FormaPagamentoResponse realizarPagamento(Compra compra) {
        compra.setStatus(StatusCompra.EM_PROCESSAMENTO);
        return FormaPagamentoResponse.builder()
                .codigoTransacao(UUID.randomUUID().toString()).build();
    }
}
