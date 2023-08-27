package tech.ada.bootcamp.arquitetura.cafeservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime dataCompra;

    private double valorTotal;

    private double totalDescontos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

}
