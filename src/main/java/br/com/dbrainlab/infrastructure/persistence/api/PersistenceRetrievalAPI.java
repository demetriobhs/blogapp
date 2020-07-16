package br.com.dbrainlab.infrastructure.persistence.api;

import br.com.dbrainlab.infrastructure.data.DataRetriever;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

import java.util.Collection;

import static br.com.dbrainlab.infrastructure.persistence.repository.provider.RepositoryProvider.getRepository;

public interface PersistenceRetrievalAPI<M extends IdentityModel> extends DataRetriever<M>, PersistenceAPI<M> {

    @Override
    default M findById(Long id) {
        return getRepository(getModelClass()).findById(id).orElse(null);
    }

    @Override
    default Collection<M> findAll() {
        return getRepository(getModelClass()).findAll();
    }

}
