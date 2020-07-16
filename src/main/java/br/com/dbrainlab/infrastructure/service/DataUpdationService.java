package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataUpdater;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceUpdationAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;

import static br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider.getPersistenceAPI;
import static br.com.dbrainlab.infrastructure.service.mapper.provider.MapperProvider.getMapper;

public interface DataUpdationService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataUpdater<R>, DataHandlingService<M, R> {

    @Override
    default R update(R representation) {
        PersistenceUpdationAPI<M> persistenceAPI = (PersistenceUpdationAPI<M>) getPersistenceAPI(getModelClass());
        Mapper<R, M> mapper = getMapper(getRepresentationClass(), getModelClass());

        M model = mapper.map(representation);
        M updatedModel = persistenceAPI.update(model);

        return mapper.mapBack(updatedModel);
    }

}
