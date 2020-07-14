package br.com.dbrainlab.post.reply;

import br.com.dbrainlab.infrastructure.persistence.IdentityModel;
import br.com.dbrainlab.post.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Reply extends IdentityModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String author;
	
	private String text;
	
	private Date date;

	private ReplyStatus status;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "parent_reply_id")
	private Reply parentReply;
	
	@OneToMany(mappedBy = "parent")
	private List<Reply> subReplies = new ArrayList<>();

}
