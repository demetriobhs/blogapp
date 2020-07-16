package br.com.dbrainlab.infrastructure.resource;

import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;
import org.springframework.http.ResponseEntity;

public interface UpdateDataWebAPI<D extends IdentityRepresentation> {

    ResponseEntity<?> putData(Long id, D dto);

    ResponseEntity<?> patchData(Long id, D dto);

    default ResponseEntity<?> dataWasUpdated(D dto) {
        // TODO Conferir se o retorno OK eh o correto pra update
        return ResponseEntity.ok(dto);
    }

}
