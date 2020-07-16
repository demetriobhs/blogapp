package br.com.dbrainlab.infrastructure.persistence.api;

import br.com.dbrainlab.infrastructure.persistence.model.HasModelClassAccess;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

public interface PersistenceAPI<M extends IdentityModel> extends HasModelClassAccess<M> {

}
