package br.com.dbrainlab.infrastructure.resource;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dbrainlab.infrastructure.service.IdentityDTO;

public interface DataManipulationResource<D extends IdentityDTO> {
	
	ResponseEntity<?> postResource(D dto);
	
	ResponseEntity<?> getResource(Long id);
	
	ResponseEntity<Collection<?>> getAllResources();
	
	ResponseEntity<?> putResource(Long id, D dto);
	
	ResponseEntity<?> patchResource(Long id, D dto);
	
	ResponseEntity<?> deleteResource(Long id);
	
	public default ResponseEntity<?> created(D dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(dto.getId())
									.toUri();
		
		return ResponseEntity
				.created(uri)
				.body(dto);
	}
	
	public default ResponseEntity<?> found(D dto) {
		return ResponseEntity.ok(dto);
	}
	
	public default ResponseEntity<Collection<?>> found(Collection<D> dtos) {
		return ResponseEntity.ok(dtos);
	}
	
	public default ResponseEntity<?> updated(D dto) {
		// TODO Conferir se o retorno OK eh o correto pra update
		return ResponseEntity.ok(dto);
	}
	
	public default ResponseEntity<?> deleted(D dto) {
		// FIXME ta errado, nao eh OK como retorno, tem que pesquisar qual eh
		return ResponseEntity.ok(dto);
	}

}
