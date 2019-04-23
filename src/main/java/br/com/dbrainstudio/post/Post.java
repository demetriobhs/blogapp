package br.com.dbrainstudio.post;

import java.util.Date;
import java.util.List;

import br.com.dbrainstudio.category.Category;
import br.com.dbrainstudio.reply.Reply;
import lombok.Data;

@Data
public class Post {
	
	private String title;
	
	private Date creationDate;
	
	private Category category;
	
	private List<Section> sections;
	
	private List<Reply> replies;
	
}
