package br.com.dbrainstudio.reply;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import br.com.dbrainstudio.entity.BaseEntity;
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
	
	private List<Reply> replies;

}
