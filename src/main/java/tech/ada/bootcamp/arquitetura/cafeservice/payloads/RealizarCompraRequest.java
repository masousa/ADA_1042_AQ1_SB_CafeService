package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RealizarCompraRequest {
    private List<ItemCompraRequest> items;
    @JsonProperty("identificador_cliente")
    private String identificadorCliente;
    private FormaPagamentoRequest formaPagamento;

}
