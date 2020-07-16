package br.com.dbrainlab.infrastructure.data;

import java.util.Collection;

public interface DataRetriever<E> {

    E findById(Long id);

    Collection<E> findAll();

}
