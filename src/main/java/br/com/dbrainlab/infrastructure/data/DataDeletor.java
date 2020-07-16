package br.com.dbrainlab.infrastructure.data;

public interface DataDeletor<E> {

    E deleteById(Long id);

}
