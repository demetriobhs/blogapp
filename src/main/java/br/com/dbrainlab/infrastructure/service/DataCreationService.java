package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataCreator;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceCreationAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;

import static br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider.getPersistenceAPI;

public interface DataCreationService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataCreator<R>, DataHandlingService<M> {

    Mapper<R, M> getMapper();

    @Override
    default R create(R representation) {
        PersistenceCreationAPI<M> persistenceAPI = (PersistenceCreationAPI<M>) getPersistenceAPI(getModelClass());

        M model = getMapper().map(representation);
        M savedModel = persistenceAPI.create(model);

        return getMapper().mapBack(savedModel);
    }

}
