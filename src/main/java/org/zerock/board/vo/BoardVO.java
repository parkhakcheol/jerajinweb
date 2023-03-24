package org.zerock.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private long no;
	private String title, content, id;
	private Date regdate;
	private long readcount;
	//private String pw;
}
