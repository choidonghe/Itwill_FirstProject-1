package com.itwillbs.domain;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pass;
	private String name;
	private String email;
	private String phone;
	private String company_name;
	private String company_phone;
	private Timestamp regdate;
	private int eno;
	private String rank;
	private String sns_type;
	private String sns_id;
	private String sns_email;
	private String salt;
	
	

}