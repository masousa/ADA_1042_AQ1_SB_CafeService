package tech.ada.bootcamp.arquitetura.cafeservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item_compra")
public class ItemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_combo")
    private Combo combo;

    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;

    private Long quantidade;

    private double desconto;

    private double valorBruto;

    private double total;

}
