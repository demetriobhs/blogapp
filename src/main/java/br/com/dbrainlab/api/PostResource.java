package br.com.dbrainlab.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostResource {
	
	@GetMapping
	public String listar() {
		return "REST ok!";
	}

}
