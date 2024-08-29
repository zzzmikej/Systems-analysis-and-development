package sptechschool.crudsimples.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Autor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String nome;
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;
}
