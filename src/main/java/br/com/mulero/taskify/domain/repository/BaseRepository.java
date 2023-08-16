package br.com.mulero.taskify.domain.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E, I> extends JpaRepository<E, I>, JpaSpecificationExecutor<E> {

    static ExampleMatcher getExampleMatcher() {
        return ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    }

    default Example<E> createExample(E entity) {
        return Example.of(entity, getExampleMatcher());
    }
}
