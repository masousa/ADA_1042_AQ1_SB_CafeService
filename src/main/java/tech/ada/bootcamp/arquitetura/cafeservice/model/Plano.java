package tech.ada.bootcamp.arquitetura.cafeservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String descricao;
    private TipoDesconto tipoDesconto;
    private double desconto;

}
