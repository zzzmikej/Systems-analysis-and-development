package school.sptech.marketplaceresumido.service.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.marketplaceresumido.data.ProdutoRepository;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.entity.enums.ProdutoTipoEnum;
import school.sptech.marketplaceresumido.exception.EntidadeNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    @DisplayName("Teste correto se, ao chamar o listar()" +
            " retorna uma lista com 2 produtos")
    void cenarioCorreto1() {
        // GIVEN
        List<Produto> produtosEsperado = List.of(
                new Produto(1, "Bolacha", "Bolacha boa", "123", 5.0, ProdutoTipoEnum.ACESSORIO),
                new Produto(2, "Biscoito", "Biscoito bom", "321", 5.0, ProdutoTipoEnum.ACESSORIO)
        );

        // WHEN
        when(repository.findAll()).thenReturn(produtosEsperado);

        // THEN
        List<Produto> resposta = service.listar();

        // ASSERT
        assertEquals(produtosEsperado.size(), resposta.size());
        assertEquals(produtosEsperado.get(0).getNome(), resposta.get(0).getNome());

        for (int i = 0; i < produtosEsperado.size(); i++) {

            assertEquals(produtosEsperado.get(i).getId(), resposta.get(i).getId());
            assertEquals(produtosEsperado.get(i).getNome(), resposta.get(i).getNome());
            assertEquals(produtosEsperado.get(i).getDescricao(), resposta.get(i).getDescricao());
            assertEquals(produtosEsperado.get(i).getCodigoBarra(), resposta.get(i).getCodigoBarra());
            assertEquals(produtosEsperado.get(i).getPreco(), resposta.get(i).getPreco());
        }

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Teste incorreto se, ao chamar o listar() retorna uma lista vazia")
    void cenarioIncorreto1() {
        // GIVEN
        var produtos = new ArrayList<Produto>();

        // WHEN
        when(repository.findAll()).thenReturn(produtos);

        // THEN
        List<Produto> resposta = service.listar();

        // ASSERT
        assertTrue(resposta.isEmpty());
    }

    @Test
    @DisplayName("Teste correto se, ao buscar por id retorna um produto")
    void cenarioCorretoPorId() {
        // GIVEN
        Produto produto = new Produto(1, "Bergamota", "Mexerica do sul", "123", 4.0, ProdutoTipoEnum.ACESSORIO);
        Integer idInformado = 1;

        // WHEN
        when(repository.findById(idInformado)).thenReturn(Optional.of(produto));

        // THEN
        Produto resposta = service.buscaPorId(idInformado);

        // ASSERT
        assertEquals(idInformado, resposta.getId());
        assertEquals(produto.getNome(), resposta.getNome());

        verify(repository, times(1)).findById(idInformado);
        verify(repository, times(0)).findAll();
    }

    @Test
    @DisplayName("Teste incorreto se, ao passar um id, não existe o produto")
    void cenarioIncorretoPorId() {
        // GIVEN
//        Integer idInformado = 1; // caso não queira deixar explicito

        // WHEN
        // Adicionamos any() para "literalmente" qualquer coisa
        when(repository.findById(any())).thenReturn(Optional.empty());

        // THEN/ASSERT - captação de exception
        assertThrows(EntidadeNaoEncontradaException.class,
                () -> service.buscaPorId(1));

        // ASSERT
        verify(repository, times(1)).findById(any());
        verify(repository, times(0)).findAll();
    }


    @Test
    @DisplayName("Dado que, vou salvar, salve no banco e retorne o objeto com id")
    void cenarioSaveCorreto() {
        // GIVEN - Configuração 1/2
        Produto produtoParaSalvar = new Produto(
                null,
                "Tangerina",
                "Bergamota do sudeste",
                "123",
                30.0,
                ProdutoTipoEnum.MODA);
        Produto produtoSalvo = new Produto(
                1,
                "Tangerina",
                "Bergamota do sudeste",
                "123",
                30.0,
                ProdutoTipoEnum.MODA);

        // WHEN - Configuração 2/2
        when(repository.save(produtoParaSalvar)).thenReturn(produtoSalvo);

        // THEN - A simulação da chamada (passo o produto para salvar e tenho uma resposta)
        Produto produtoResposta = service.salvar(produtoParaSalvar);

        // ASSERT - Aferições/Asserções
        assertNotNull(produtoResposta.getId());
        assertEquals(produtoParaSalvar.getNome(), produtoResposta.getNome());
        assertEquals(produtoParaSalvar.getDescricao(), produtoResposta.getDescricao());

        verify(repository, times(1)).save(produtoParaSalvar);
        verify(repository, times(0)).findById(any());
    }

    @Test
    @DisplayName("Dado que, passei um id válido, salve o objeto atualizado e retorna ele com o valor")
    void cenarioAtualizacaoCorreto() {
        Produto produtoAtualizacao = new Produto(null,
                "Robson",
                "era pra ser algo",
                "123",
                25.0,
                ProdutoTipoEnum.ELETRONICO);
        Produto produtoAtualizado = new Produto(1,
                "Robson",
                "era pra ser algo",
                "123",
                25.0,
                ProdutoTipoEnum.ELETRONICO);
        Integer idInformado = 1;

        when(repository.existsById(idInformado)).thenReturn(Boolean.TRUE);
        when(repository.save(produtoAtualizacao)).thenReturn(produtoAtualizado);

        Produto produtoResposta = service.atualizar(idInformado, produtoAtualizacao);

        assertEquals(produtoAtualizacao.getNome(), produtoResposta.getNome());
        assertEquals(produtoAtualizacao.getPreco(), produtoResposta.getPreco());

        verify(repository, times(1)).existsById(idInformado);
        verify(repository, times(0)).findById(idInformado);
        verify(repository, times(0)).findAll();
        verify(repository, times(1)).save(produtoAtualizacao);
    }

    @Test
    @DisplayName("Dado que, tenho um id, ao atualizar, não existe o id no banco")
    void cenarioAtualizacaoIncorreto() {

        when(repository.existsById(any())).thenReturn(Boolean.FALSE);

        assertThrows(EntidadeNaoEncontradaException.class,
                () -> service.atualizar(1, null));

        verify(repository, times(1)).existsById(any());
        verify(repository, times(0)).findById(any());
        verify(repository, times(0)).findAll();
    }


}