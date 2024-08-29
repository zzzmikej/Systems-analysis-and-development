package school.sptech.marketplaceresumido.service;

public class CalculadoraService {

    public Double calculoIcms(Double preco) {

        if (preco == null) {
            throw new IllegalArgumentException("O valor não pode ser null");
        }

        if (preco == 0) {
            throw new IllegalArgumentException("O valor não pode ser zero");
        }

        if (preco < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo");
        }

        return preco * 0.18;
    }
}
