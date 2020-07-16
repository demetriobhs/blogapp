package br.com.dbrainlab.infrastructure.web;

import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;

public interface DataHandlingWebAPI<D extends IdentityRepresentation>
	   extends DataCreationWebAPI<D>,
			   DataRetrievalWebAPI<D>,
			   DataUpdationWebAPI<D>,
			   DataDeletionWebAPI<D> {

}
