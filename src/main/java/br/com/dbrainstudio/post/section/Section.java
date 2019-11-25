package br.com.dbrainstudio.post.section;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.dbrainstudio.entity.BaseEntity;
import br.com.dbrainstudio.post.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String title;
	
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

}
