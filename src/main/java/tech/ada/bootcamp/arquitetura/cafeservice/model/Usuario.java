package tech.ada.bootcamp.arquitetura.cafeservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private  String identificador;
    private String login;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

}
