package br.com.dbrainlab.domain.post.service;

import br.com.dbrainlab.domain.post.persistence.model.Post;
import br.com.dbrainlab.domain.post.service.representation.PostRepresentation;
import br.com.dbrainlab.infrastructure.service.DataCrudService;

public interface PostDataHandlingService extends DataCrudService<Post, PostRepresentation> {

}
