package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoRequest {

    private TipoPagamento tipoPagamento;
    private String numeroCartao;
    private String cvv;
    private String nomeTitular;
}
