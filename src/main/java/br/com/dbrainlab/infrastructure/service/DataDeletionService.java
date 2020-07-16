package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataDeletor;
import br.com.dbrainlab.infrastructure.persistence.api.PersistenceDeletionAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.mapper.Mapper;
import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;

import static br.com.dbrainlab.infrastructure.persistence.api.provider.PersistenceAPIProvider.getPersistenceAPI;
import static br.com.dbrainlab.infrastructure.service.mapper.provider.MapperProvider.getMapper;

public interface DataDeletionService<M extends IdentityModel, R extends IdentityRepresentation>
       extends DataDeletor<R>, DataHandlingService<M, R> {

    @Override
    default R deleteById(Long id) {
        PersistenceDeletionAPI<M> persistenceAPI = (PersistenceDeletionAPI<M>) getPersistenceAPI(getModelClass());
        Mapper<R, M> mapper = getMapper(getRepresentationClass(), getModelClass());

        M deletedModel = persistenceAPI.deleteById(id);

        return mapper.mapBack(deletedModel);
    }

}
