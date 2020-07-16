package br.com.dbrainlab.infrastructure.resource;

import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;

public interface DataHandlingWebAPI<D extends IdentityRepresentation> extends CreateDataWebAPI<D>,
        RetrieveDataWebAPI<D>,
																   UpdateDataWebAPI<D>,
																   DeleteDataWebAPI<D> {

}
