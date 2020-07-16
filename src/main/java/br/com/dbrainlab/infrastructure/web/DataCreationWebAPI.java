package br.com.dbrainlab.infrastructure.web;

import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public interface DataCreationWebAPI<R extends IdentityRepresentation> {

    ResponseEntity<?> postData(R representation);

    default ResponseEntity<?> dataWasCreated(R representation) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(representation.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(representation);
    }

}
