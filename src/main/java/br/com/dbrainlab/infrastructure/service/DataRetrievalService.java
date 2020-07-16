package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataRetriever;
import br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceRetrievalAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;

import java.util.Collection;
import java.util.stream.Collectors;

public interface DataRetrievalService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataRetriever<R>, DataHandlingService<M> {

    Mapper<R, M> getMapper();

    @Override
    default R findById(Long id) {
        getPersistenceAPI();
        M fetchedModel = getPersistenceAPI().findById(id);

        return getMapper().mapBack(fetchedModel);
    }

    @Override
    default Collection<R> findAll() {
        Collection<M> fetchedModels = getPersistenceAPI().findAll();

        return fetchedModels.stream()
                .map(model -> getMapper().mapBack(model))
                .collect(Collectors.toUnmodifiableList());
    }

    private PersistenceRetrievalAPI<M> getPersistenceAPI() {
        return (PersistenceRetrievalAPI<M>) PersistenceAPIProvider.getPersistenceAPI(getModelClass());
    }

}
