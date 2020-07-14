package br.com.dbrainlab.post;

import org.springframework.stereotype.Repository;

import br.com.dbrainlab.infrastructure.persistence.BaseRepository;

@Repository
public interface PostRepository extends BaseRepository<Post> {

}
