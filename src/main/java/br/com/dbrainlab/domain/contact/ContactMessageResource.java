package br.com.dbrainlab.domain.contact;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageResource {



    @PostMapping
    public ResponseEntity<?> receiveContactMessage() {


        return ResponseEntity.ok().build();
    }

}
