package br.com.dbrainstudio.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.dbrainstudio.category.Category;
import br.com.dbrainstudio.entity.BaseEntity;
import br.com.dbrainstudio.post.reply.Reply;
import br.com.dbrainstudio.post.section.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String title;
	
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "post")
	private List<Section> sections = new ArrayList<>();
	
	@OneToMany(mappedBy = "post")
	private List<Reply> replies = new ArrayList<>();
	
}
