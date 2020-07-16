package br.com.dbrainlab.domain.post.persistence.api.impl;

import br.com.dbrainlab.domain.post.persistence.api.PostPersistenceAPI;
import br.com.dbrainlab.domain.post.persistence.model.Post;
import br.com.dbrainlab.domain.post.persistence.repository.PostRepository;
import br.com.dbrainlab.infrastructure.persistence.api.impl.DefaultPersistenceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersistenceAPIImpl extends DefaultPersistenceAPI<Post> implements PostPersistenceAPI {

    @Autowired
    public PostPersistenceAPIImpl(PostRepository repository) {
        super(Post.class, repository);
    }

    @Override
    public Class<Post> getModelClass() {
        return Post.class;
    }

}
