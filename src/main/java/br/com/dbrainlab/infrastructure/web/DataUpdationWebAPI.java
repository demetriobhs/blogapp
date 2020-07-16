package br.com.dbrainlab.infrastructure.web;

import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;
import org.springframework.http.ResponseEntity;

public interface DataUpdationWebAPI<R extends IdentityRepresentation> {

    ResponseEntity<?> putData(Long id, R representation);

    ResponseEntity<?> patchData(Long id, R representation);

    default ResponseEntity<?> dataWasUpdated(R representation) {
        // TODO Conferir se o retorno OK eh o correto pra update
        return ResponseEntity.ok(representation);
    }

}
