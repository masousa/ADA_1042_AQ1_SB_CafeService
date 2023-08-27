package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RealizarCompraResponse {
    private LocalDate dataCompra;
    private double total;

    private List<ItemCompraResponse> items;
}
