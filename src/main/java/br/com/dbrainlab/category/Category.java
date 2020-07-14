package br.com.dbrainlab.category;

import br.com.dbrainlab.infrastructure.persistence.IdentityModel;
import br.com.dbrainlab.post.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Category extends IdentityModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	@OneToMany(mappedBy = "category")
	private List<Post> posts = new ArrayList<>();

}
