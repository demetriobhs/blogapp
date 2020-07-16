package br.com.dbrainlab.infrastructure.service;

import br.com.dbrainlab.infrastructure.data.DataHandler;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;

public interface DataCrudService<M extends IdentityModel, R extends IdentityRepresentation>
	   extends DataHandler<R>,
			   DataCreationService<M, R>,
			   DataRetrievalService<M, R>,
			   DataUpdationService<M, R>,
			   DataDeletionService<M, R> {

}
