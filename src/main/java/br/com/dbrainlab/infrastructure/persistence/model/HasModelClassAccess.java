package br.com.dbrainlab.infrastructure.persistence.model;

public interface HasModelClassAccess<M> {

    Class<M> getModelClass();

}
