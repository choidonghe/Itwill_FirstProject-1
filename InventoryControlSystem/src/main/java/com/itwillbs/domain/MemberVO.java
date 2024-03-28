package com.itwillbs.domain;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pass;
	private String salt;
	private String name;
	private String email;
	private String phone;
	private int eno;
	private String position;
	private String sns_email;

	private Timestamp regdate;
	
	private String auth;
	

}