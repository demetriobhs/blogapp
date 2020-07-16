package br.com.dbrainlab.infrastructure.service.impl;

import br.com.dbrainlab.infrastructure.persistence.api.PersistenceAPI;
import br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

public class DefaultDataHandlingService<M extends IdentityModel> {

    public DefaultDataHandlingService(Class<M> clazz, PersistenceAPI<M> persistenceAPI) {
        PersistenceAPIProvider.registerPersistenceAPI(clazz, persistenceAPI);
    }

}
