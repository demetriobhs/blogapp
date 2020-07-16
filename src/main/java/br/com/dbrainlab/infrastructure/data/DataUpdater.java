package br.com.dbrainlab.infrastructure.data;

public interface DataUpdater<E> {

    E update(E element);

}
