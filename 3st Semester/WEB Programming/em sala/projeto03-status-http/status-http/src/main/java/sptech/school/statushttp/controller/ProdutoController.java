package sptech.school.statushttp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.statushttp.Produto;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ArrayList<Produto> produtos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<Produto>> listarProdutos(){
        if (produtos.isEmpty()){
            System.out.println("[ ]");
        } else {
            return ResponseEntity.status(200).body(produtos);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/estoque/{qtdEstoque}")
    public ResponseEntity<ArrayList<Produto>> buscarEstoque(@PathVariable int qtdEstoque){
        ArrayList<Produto> filtro = new ArrayList<>();
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getQtdEstoque() >= qtdEstoque){
               filtro.add(produtos.get(i));
            }
        }
        if (filtro.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filtro);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto novoProduto){
        this.produtos.add(novoProduto);
        return ResponseEntity.status(201).body(novoProduto);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Produto> alterar(@RequestBody Produto alterarProduto, @PathVariable int indice){
        if (indice >= 0 || indice < produtos.size()) {
            this.produtos.set(indice, alterarProduto);
            return ResponseEntity.status(200).body(produtos.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> excluir(@PathVariable int indice){
        if (indice >= 0 || indice < produtos.size()) {
            this.produtos.remove(indice);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/busca-por-nome")
    public ResponseEntity<ArrayList<Produto>> buscaPorNome(@RequestParam String nome){
        ArrayList<Produto> produtosEncontrados = new ArrayList<>();

        for (Produto produtoDaVez : produtos){
            if (produtoDaVez.getNome().contains(nome)) {
                produtosEncontrados.add(produtoDaVez);
            }
        }
        if (produtosEncontrados.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(produtosEncontrados);
    }
}