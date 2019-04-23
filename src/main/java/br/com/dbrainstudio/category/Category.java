package br.com.dbrainstudio.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "category")
	private List<Post> posts = new ArrayList<>();

}
