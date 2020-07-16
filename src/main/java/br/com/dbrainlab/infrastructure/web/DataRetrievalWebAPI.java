package br.com.dbrainlab.infrastructure.web;

import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface DataRetrievalWebAPI<R extends IdentityRepresentation> {

    ResponseEntity<?> getDataById(Long id);

    ResponseEntity<Collection<?>> getAllData();

    default ResponseEntity<?> dataWasFound(R representation) {
        return ResponseEntity.ok(representation);
    }

    default ResponseEntity<Collection<?>> dataWasFound(Collection<R> representations) {
        return ResponseEntity.ok(representations);
    }

}
