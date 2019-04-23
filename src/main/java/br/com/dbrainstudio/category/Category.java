package br.com.dbrainstudio.category;

import java.util.List;

import br.com.dbrainstudio.post.Post;
import lombok.Data;

@Data
public class Category {
	
	private String name;
	
	private List<Post> posts;

}
