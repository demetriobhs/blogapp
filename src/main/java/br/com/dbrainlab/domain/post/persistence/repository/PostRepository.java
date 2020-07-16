package br.com.dbrainlab.domain.post.persistence.repository;

import br.com.dbrainlab.domain.post.persistence.model.Post;
import org.springframework.stereotype.Repository;

import br.com.dbrainlab.infrastructure.persistence.repository.impl.DefaultRepository;

@Repository
public interface PostRepository extends DefaultRepository<Post> {

}
