package tech.ada.bootcamp.arquitetura.cafeservice.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.TipoPagamento;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RealizarPagamentoFactory {

    private final Map<TipoPagamento, RealizarPagamentoService> realizarPagamentoServiceMap;

    @Autowired
    private RealizarPagamentoFactory(List<RealizarPagamentoService> realizarPagamentoServiceList){
        realizarPagamentoServiceMap = realizarPagamentoServiceList.stream()
                .collect(Collectors.toUnmodifiableMap(RealizarPagamentoService::getTipoPagamento, Function.identity()));
    }

    public RealizarPagamentoService getFormaPagamento(TipoPagamento tipoPagamento){
        return realizarPagamentoServiceMap.get(tipoPagamento);
    }
}
