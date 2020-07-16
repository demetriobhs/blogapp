package br.com.dbrainlab.api;

import br.com.dbrainlab.domain.post.service.impl.PostDataHandlingServiceImpl;
import br.com.dbrainlab.domain.post.service.representation.PostRepresentation;
import br.com.dbrainlab.infrastructure.resource.DataHandlingWebAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/post")
public class PostDataHandlingWebAPI implements DataHandlingWebAPI<PostRepresentation> {

    @Autowired
    private PostDataHandlingServiceImpl service;

    @PostMapping
    @Override
    public ResponseEntity<?> postData(@RequestBody PostRepresentation postDTO) {
        PostRepresentation postCreated = service.create(postDTO);

        return dataWasCreated(postCreated);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getDataById(@PathVariable("id") Long id) {
        PostRepresentation postFetched = service.findById(id);

        return dataWasFound(postFetched);
    }

    @Override
    public ResponseEntity<Collection<?>> getAllData() {
        return null;
    }

    @Override
    public ResponseEntity<?> putData(Long id, PostRepresentation dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> patchData(Long id, PostRepresentation dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteDataById(@PathVariable("id") Long id) {
        PostRepresentation postDeleted = service.deleteById(id);

        return dataWasDeleted(postDeleted);
    }

}
