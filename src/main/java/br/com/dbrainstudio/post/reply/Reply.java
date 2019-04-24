package br.com.dbrainstudio.post.reply;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	
	@Lob
	@Basic
	private String message;
	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@OneToMany(mappedBy = "reply")
	private List<SubReply> subReplies = new ArrayList<>();

}
