package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataCreator;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceCreationAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;

import static br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider.getPersistenceAPI;
import static br.com.dbrainlab.infrastructure.service.mapper.provider.MapperProvider.getMapper;

public interface DataCreationService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataCreator<R>, DataHandlingService<M, R> {

    @Override
    default R create(R representation) {
        PersistenceCreationAPI<M> persistenceAPI = (PersistenceCreationAPI<M>) getPersistenceAPI(getModelClass());
        Mapper<R, M> mapper = getMapper(getRepresentationClass(), getModelClass());

        M model = mapper.map(representation);
        M savedModel = persistenceAPI.create(model);

        return mapper.mapBack(savedModel);
    }

}
