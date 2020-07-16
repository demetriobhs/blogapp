package br.com.dbrainlab.domain.post.service.impl;

import br.com.dbrainlab.domain.post.persistence.api.PostPersistenceAPI;
import br.com.dbrainlab.domain.post.persistence.model.Post;
import br.com.dbrainlab.domain.post.service.PostDataHandlingService;
import br.com.dbrainlab.domain.post.service.representation.PostRepresentation;
import br.com.dbrainlab.infrastructure.service.impl.DefaultDataHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDataHandlingServiceImpl extends DefaultDataHandlingService<Post> implements PostDataHandlingService {

    @Autowired
    public PostDataHandlingServiceImpl(PostPersistenceAPI postPersistenceAPI) {
        super(Post.class, postPersistenceAPI);
    }

    @Override
    public Class<Post> getModelClass() {
        return Post.class;
    }

    @Override
    public Class<PostRepresentation> getRepresentationClass() {
        return PostRepresentation.class;
    }
}
