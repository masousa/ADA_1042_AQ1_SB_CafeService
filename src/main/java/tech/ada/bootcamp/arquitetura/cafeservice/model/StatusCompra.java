package tech.ada.bootcamp.arquitetura.cafeservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCompra {

    EM_PROCESSAMENTO("Em processamento"), PENDENTE("Pendente");

    private final String label;

}
