package br.com.dbrainlab.infrastructure.web;

import br.com.dbrainlab.infrastructure.service.representation.impl.IdentityRepresentation;
import org.springframework.http.ResponseEntity;

public interface DataDeletionWebAPI<R extends IdentityRepresentation> {

    ResponseEntity<?> deleteDataById(Long id);

    public default ResponseEntity<?> dataWasDeleted(R representation) {
        // FIXME ta errado, nao eh OK como retorno, tem que pesquisar qual eh
        return ResponseEntity.ok(representation);
    }

}
