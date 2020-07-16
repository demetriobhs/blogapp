package br.com.dbrainlab.infrastructure.persistence.api;

import br.com.dbrainlab.infrastructure.data.DataUpdater;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

import static br.com.dbrainlab.infrastructure.persistence.repository.provider.RepositoryProvider.getRepository;

public interface PersistenceUpdationAPI<M extends IdentityModel> extends DataUpdater<M>, PersistenceAPI<M> {

    @Override
    default M update(M model) {
        if (model.getId() == null) {
            // TODO Lancar excecao
        }

        return getRepository(getModelClass()).save(model);
    }

}
