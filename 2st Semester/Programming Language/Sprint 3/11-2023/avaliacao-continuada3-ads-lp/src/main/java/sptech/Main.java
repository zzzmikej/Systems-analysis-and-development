package sptech;

public class Main {

    public static void main(String[] args) {
        Produto produto01 = new ProdutoImportado("123456", "Produto A", "Descrição do Produto A", 29.99, 10, "Eletrônicos", "Uruguai", 1.0);
        Produto produto02 = new ProdutoImportado("789012", "Produto B", "Descrição do Produto B", 19.99, 20, "Roupas", "Argentina", 0.5);
        Produto produto03 = new ProdutoNacional("345678", "Produto C", "Descrição do Produto C", 39.99, 15, "Livros", "Brasil");
        Produto produto04 = new ProdutoNacional("987654", "Produto D", "Descrição do Produto D", 99.99, 35, "Alimentos", "Brasil");
        Produto produto05 = new ProdutoImportado("654987", "Produto E", "Descrição do Produto E", 9.99, 55, "Alimentos", "Japão", 10.0);

        Carrinho c = new Carrinho();

        c.adicionarProduto(produto01);
        c.adicionarProduto(produto02);
        c.adicionarProduto(produto03);
        c.adicionarProduto(produto04);
        c.adicionarProduto(produto05);
    }
}