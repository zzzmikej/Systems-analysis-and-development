package school.sptech.marketplaceresumido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.sptech.marketplaceresumido.entity.enums.ProdutoTipoEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String codigoBarra;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private ProdutoTipoEnum tipo;
}
