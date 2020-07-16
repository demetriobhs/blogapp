package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.persistence.model.HasModelClassAccess;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

public interface DataHandlingService<M extends IdentityModel> extends HasModelClassAccess<M> {
}
