package br.com.dbrainstudio.reply;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Reply {
	
	private String author;
	
	private String text;
	
	private Date date;
	
	private List<Reply> replies;

}
