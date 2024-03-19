package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReleaseVO {
	
	private int divcode;
	private String id;
	private String pno;
	private String pname;
	private String category;
	private Timestamp release_date;
	private Timestamp update_date;
	private int price;
	private Timestamp order_date;
	private int order_count;
	private String delivery_company;
	private String delivery_phone;
	private String delivery_manager;

}
