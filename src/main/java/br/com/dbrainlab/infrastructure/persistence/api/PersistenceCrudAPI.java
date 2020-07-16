package br.com.dbrainlab.infrastructure.persistence.api;

import br.com.dbrainlab.infrastructure.data.DataHandler;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

public interface PersistenceCrudAPI<M extends IdentityModel>
	   extends DataHandler<M>,
			   PersistenceCreationAPI<M>,
			   PersistenceRetrievalAPI<M>,
			   PersistenceUpdationAPI<M>,
			   PersistenceDeletionAPI<M> {

}
