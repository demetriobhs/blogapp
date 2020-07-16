package br.com.dbrainlab.infrastructure.persistence.api;

import br.com.dbrainlab.infrastructure.data.DataDeletor;
import br.com.dbrainlab.infrastructure.persistence.exception.NoSuchInstanceException;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.persistence.repository.impl.DefaultRepository;

import static br.com.dbrainlab.infrastructure.persistence.repository.provider.RepositoryProvider.getRepository;

public interface PersistenceDeletionAPI<M extends IdentityModel> extends DataDeletor<M>, PersistenceAPI<M> {

    @Override
    default M deleteById(Long id) {
        DefaultRepository<M> repository = getRepository(getModelClass());

        M model = repository.findById(id).orElseThrow(() -> new NoSuchInstanceException(id));
        repository.delete(model);

        return model;
    }

}
