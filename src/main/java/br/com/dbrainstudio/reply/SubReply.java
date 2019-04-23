package br.com.dbrainstudio.reply;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	
	private String text;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "reply_id")
	private Reply reply;

}
