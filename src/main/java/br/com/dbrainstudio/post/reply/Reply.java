package br.com.dbrainstudio.post.reply;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.dbrainstudio.entity.BaseEntity;
import br.com.dbrainstudio.post.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Reply extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String author;
	
	private String text;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@OneToMany(mappedBy = "reply")
	private List<SubReply> subReplies = new ArrayList<>();

}
