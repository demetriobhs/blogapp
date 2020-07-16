package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataDeletor;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceDeletionAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;

import static br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider.getPersistenceAPI;

public interface DataDeletionService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataDeletor<R>, DataHandlingService<M> {

    Mapper<R, M> getMapper();

    @Override
    default R deleteById(Long id) {
        PersistenceDeletionAPI<M> persistenceAPI = (PersistenceDeletionAPI<M>) getPersistenceAPI(getModelClass());

        M deletedModel = persistenceAPI.deleteById(id);

        return getMapper().mapBack(deletedModel);
    }

}
