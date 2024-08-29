import produto.Produto;
import produto.ProdutoNacional;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho(List<Produto> produtos) {
        this.produtos = new ArrayList<>();
    }

    public Boolean existeProdutoPorCodigoBarra(String codigoBarras) {
        int i = 0;
        Boolean existe = false;

        while (!existe) {
            if (produtos.get(i).getCodigoBarras().equals(codigoBarras)) {
                System.out.println("O produto existe!");
                existe = true;
            } else {
                System.out.println("O produto nao existe!");

            }
            i++;
        }
        return existe;
    }

    public void adicionarProduto(Produto produto) {
        Boolean existe = false;
        int i = 0;

        while (!existe) {
            if (produtos.get(i).getCodigoBarras().equals(produto.getCodigoBarras())) {
                existe = true;
            } else {
                produtos.add(produto);
                break;
            }
            i++;

        }
    }

    public Boolean existePorIndice (Integer indice) {
        int i = 0;
        Boolean existe = false;

        while (!existe) {
            if (produtos.get(indice) == null) {
                System.out.println("O produto nao existe!");
            } else {
                System.out.println("O produto existe!");
                existe = true;
            }
            i++;
        }
        return existe;
    }

    public void removerProduto(Integer indice) {
        if (produtos.get(indice) == null) {
            System.out.println("Nao existe produtos a serem removidos");
        } else {
            System.out.println("""
                    O produto %s foi removido""".formatted(produtos.get(indice).getNome()));
            produtos.remove(indice);
        }
    }

    public Produto obterProduto(Integer indice) {
        if (produtos.get(indice) == null) {
            System.out.println("Nao existe produtos a serem removidos");
        } else {
           return produtos.get(indice);
        }
        return null;
    }

    public Double clcularValorTotal() {
        Double total = 0.;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco();
        }

        return total;
    }

    public Double calcularValorTotalPorCategoria(String categoria) {
        Double total = 0.;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCategoria().equals(categoria)) {
                total += produtos.get(i).getPreco();
            }
        }
        return total;
    }

    public List<Produto> buscarPorCategoria(String categoria) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCategoria().equals(categoria)) {
                System.out.println(produtos.get(i));
            }
        }
        return null;
    }
}