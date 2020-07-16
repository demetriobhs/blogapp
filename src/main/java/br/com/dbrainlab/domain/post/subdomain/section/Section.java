package br.com.dbrainlab.domain.post.subdomain.section;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.domain.post.persistence.model.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Section extends IdentityModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String title;

	@Lob
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

}
