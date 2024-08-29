package sptechschool.projectserviceexception.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import sptechschool.projectserviceexception.entity.Estabelecimento;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EstabelecimentoRepository implements JpaRepository <Estabelecimento, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Estabelecimento> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Estabelecimento> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Estabelecimento> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Estabelecimento getOne(Integer integer) {
        return null;
    }

    @Override
    public Estabelecimento getById(Integer integer) {
        return null;
    }

    @Override
    public Estabelecimento getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Estabelecimento> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Estabelecimento> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Estabelecimento> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Estabelecimento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Estabelecimento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Estabelecimento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Estabelecimento, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Estabelecimento> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Estabelecimento> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Estabelecimento> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Estabelecimento> findAll() {
        return List.of();
    }

    @Override
    public List<Estabelecimento> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Estabelecimento entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Estabelecimento> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Estabelecimento> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Estabelecimento> findAll(Pageable pageable) {
        return null;
    }
}
