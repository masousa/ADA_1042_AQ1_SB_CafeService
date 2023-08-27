package tech.ada.bootcamp.arquitetura.cafeservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descricao;

    private double valorUnitario;

    private TipoUnidade tipoUnidade;

    private Long quantidadeUnidade;

}
