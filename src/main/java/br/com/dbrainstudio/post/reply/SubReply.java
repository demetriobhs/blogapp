package br.com.dbrainstudio.post.reply;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import br.com.dbrainstudio.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class SubReply extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String author;
	
	@Lob
	@Basic
	private String message;
	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "reply_id")
	private Reply reply;

}
