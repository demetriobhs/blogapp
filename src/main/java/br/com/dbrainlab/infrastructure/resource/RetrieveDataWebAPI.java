package br.com.dbrainlab.infrastructure.resource;

import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface RetrieveDataWebAPI<D extends IdentityRepresentation> {

    ResponseEntity<?> getDataById(Long id);

    ResponseEntity<Collection<?>> getAllData();

    default ResponseEntity<?> dataWasFound(D dto) {
        return ResponseEntity.ok(dto);
    }

    default ResponseEntity<Collection<?>> dataWasFound(Collection<D> dtos) {
        return ResponseEntity.ok(dtos);
    }

}
