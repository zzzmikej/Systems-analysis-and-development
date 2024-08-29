package sptechschool.crudsimples.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDate dataPublicacao;
    private Double preco;
    @ManyToOne
    private Autor autor;
}
