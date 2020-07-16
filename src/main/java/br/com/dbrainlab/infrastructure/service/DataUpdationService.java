package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataUpdater;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceUpdationAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;

import static br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider.getPersistenceAPI;

public interface DataUpdationService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataUpdater<R>, DataHandlingService<M> {

    Mapper<R, M> getMapper();

    @Override
    default R update(R representation) {
        PersistenceUpdationAPI<M> persistenceAPI = (PersistenceUpdationAPI<M>) getPersistenceAPI(getModelClass());

        M model = getMapper().map(representation);
        M updatedModel = persistenceAPI.update(model);

        return getMapper().mapBack(updatedModel);
    }

}
