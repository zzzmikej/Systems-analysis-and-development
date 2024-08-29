package school.sptech.marketplaceresumido.entity.enums;

public enum ProdutoTipoEnum {
    ACESSORIO("Acessórios"),
    ELETRONICO("Eletrônico"),
    MODA("Moda");

    private String descricao;

    ProdutoTipoEnum(String descricao) {
        this.descricao = descricao;
    }
}
