package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import lombok.Data;

@Data
public class ItemCompraRequest {

    private Long quantidade;
    private String identificadorItem;
    private boolean isCombo;
}
