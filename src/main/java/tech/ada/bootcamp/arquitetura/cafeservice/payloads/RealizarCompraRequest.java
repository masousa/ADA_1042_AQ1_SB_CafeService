package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RealizarCompraRequest {
    private List<ItemCompraRequest> items;
    @JsonProperty("identificador_cliente")
    private String identificadorCliente;
}
