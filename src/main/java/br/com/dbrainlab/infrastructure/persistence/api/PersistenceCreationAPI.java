package br.com.dbrainlab.infrastructure.persistence.api;

import br.com.dbrainlab.infrastructure.data.DataCreator;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

import static br.com.dbrainlab.infrastructure.persistence.repository.provider.RepositoryProvider.getRepository;

public interface PersistenceCreationAPI<M extends IdentityModel> extends DataCreator<M>, PersistenceAPI<M> {

    @Override
    default M create(M model) {
        if (model.getId() != null) {
            // TODO lancar excecao
        }

        return getRepository(getModelClass()).save(model);
    }

}
