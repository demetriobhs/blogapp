package br.com.dbrainstudio.post;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import br.com.dbrainstudio.category.Category;
import br.com.dbrainstudio.entity.BaseEntity;
import br.com.dbrainstudio.reply.Reply;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String title;
	
	private Date creationDate;
	
	private Category category;
	
	private List<Section> sections;
	
	private List<Reply> replies;
	
}
