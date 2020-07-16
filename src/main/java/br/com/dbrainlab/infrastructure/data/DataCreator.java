package br.com.dbrainlab.infrastructure.data;

public interface DataCreator<E> {

    E create(E element);

}
