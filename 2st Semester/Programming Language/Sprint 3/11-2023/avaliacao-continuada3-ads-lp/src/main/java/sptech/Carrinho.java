import java.util.List;
import java.util.stream.Collectors;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (!existeProdutoPorCodigoBarras(produto.getCodigoBarras())) {
            this.produtos.add(produto);
        }
    }

    public void removerProduto(Integer indice) {
        if (existePorIndice(indice)) {
            this.produtos.remove(indice);
        }
    }

    public Produto obterProduto(Integer indice) {
        return existePorIndice(indice) ? this.produtos.get(indice) : null;
    }

    public Double calcularTotalEmEstoque() {
        return this.produtos.stream()
                .mapToDouble(Produto::calcularPrecoTotal)
                .sum();
    }

    public Double calcularTotalEmEstoquePorCategoria(String categoria) {
        return this.produtos.stream()
                .filter(produto -> produto.getCategoria().equals(categoria))
                .mapToDouble(Produto::calcularPrecoTotal)
                .sum();
    }

    public Boolean existeProdutoPorCodigoBarras(String codigoBarras) {
        return this.produtos.stream()
                .anyMatch(produto -> produto.getCodigoBarras().equals(codigoBarras));
    }

    public Boolean existePorIndice(Integer indice) {
        return indice >= 0 && indice < this.produtos.size();
    }

    public List<Produto> buscarPorCategoria(String categoria) {
        return this.produtos.stream()
                .filter(produto -> produto.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    }

    public List<Produto> ordenarPorPrecoDecrescentePorCategoria(String categoria) {
        return this.produtos.stream()
                .filter(produto -> produto.getCategoria().equals(categoria))
                .sorted((p1, p2) -> Double.compare(p2.getPreco(), p1.getPreco()))
                .collect(Collectors.toList());
    }
}

