package sptechschool.crudsimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptechschool.crudsimples.entity.Livro;

import java.time.LocalDate;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByTituloContainsIgnoreCase(String titulo);
    List<Livro> findByDataPublicacaoAfter(LocalDate data);
    List<Livro> findByDataPublicacaoBetweenAndTituloContainsIgnoreCase(LocalDate dataIn, LocalDate dataFi, String titulo);
    @Query("SELECT SUM(l.preco)FROM Livro l")
    Double sumPreco();
}
