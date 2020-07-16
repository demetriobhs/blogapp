package br.com.dbrainlab.domain.category;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.domain.post.persistence.model.Post;
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
