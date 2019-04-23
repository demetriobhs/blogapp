package br.com.dbrainstudio.category;

import java.util.List;

import javax.persistence.Entity;

import br.com.dbrainstudio.entity.BaseEntity;
import br.com.dbrainstudio.post.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private List<Post> posts;

}
