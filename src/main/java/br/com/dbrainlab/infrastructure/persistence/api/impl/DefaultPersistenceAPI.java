package br.com.dbrainlab.infrastructure.persistence.api.impl;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.persistence.repository.impl.DefaultRepository;
import br.com.dbrainlab.infrastructure.persistence.repository.provider.RepositoryProvider;

public abstract class DefaultPersistenceAPI<M extends IdentityModel> {

    public DefaultPersistenceAPI(Class<M> clazz, DefaultRepository<M> repository) {
        RepositoryProvider.registerRepository(clazz, repository);
    }
    
}
