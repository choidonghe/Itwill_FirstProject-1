package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NoticeVO {
	
	private int bno;
	private String title;
	private String content;
	private Timestamp regdate;
	private Timestamp update_date;
	private int viewcnt;

}
