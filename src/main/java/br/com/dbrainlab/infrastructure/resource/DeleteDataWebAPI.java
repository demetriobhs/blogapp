package br.com.dbrainlab.infrastructure.resource;

import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;
import org.springframework.http.ResponseEntity;

public interface DeleteDataWebAPI<D extends IdentityRepresentation> {

    ResponseEntity<?> deleteDataById(Long id);

    public default ResponseEntity<?> dataWasDeleted(D dto) {
        // FIXME ta errado, nao eh OK como retorno, tem que pesquisar qual eh
        return ResponseEntity.ok(dto);
    }

}
