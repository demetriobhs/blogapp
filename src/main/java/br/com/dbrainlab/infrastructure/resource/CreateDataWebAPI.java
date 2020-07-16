package br.com.dbrainlab.infrastructure.resource;

import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public interface CreateDataWebAPI<D extends IdentityRepresentation> {

    ResponseEntity<?> postData(D dto);

    default ResponseEntity<?> dataWasCreated(D dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(dto);
    }

}
