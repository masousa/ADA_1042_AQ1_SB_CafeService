package tech.ada.bootcamp.arquitetura.cafeservice.factory;

import tech.ada.bootcamp.arquitetura.cafeservice.model.Compra;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.TipoPagamento;

public interface RealizarPagamentoService {
    TipoPagamento getTipoPagamento();
    FormaPagamentoResponse realizarPagamento(Compra compra);
}
