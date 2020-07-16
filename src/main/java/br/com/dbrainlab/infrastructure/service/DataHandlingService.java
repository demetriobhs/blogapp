package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.persistence.model.HasModelClassAccess;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.representation.HasRepresentationClassAccess;
import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;

public interface DataHandlingService<M extends IdentityModel, R extends IdentityRepresentation>
       extends HasModelClassAccess<M>, HasRepresentationClassAccess<R> {

}
