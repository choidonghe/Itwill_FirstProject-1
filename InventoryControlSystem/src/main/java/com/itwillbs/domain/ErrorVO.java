package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ErrorVO {

	private String pno;
	private String pname;
	private String id;
	private int divcode;
	private int count;
	private Timestamp regdate; 
	private int error_count;
		
}
