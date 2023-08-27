package tech.ada.bootcamp.arquitetura.cafeservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "combo")
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descricao;

    private double valorFinal;

    @ManyToMany(cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "combo_item",
    inverseJoinColumns = @JoinColumn(name = "id_item"),
    joinColumns = @JoinColumn(name = "id_combo"))
    private List<Item> items;

}
