package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import lombok.Data;

@Data
public class ItemCompraResponse extends ItemCompraRequest{
    private double valor;
}
