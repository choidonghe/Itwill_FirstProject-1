package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StockDetailVO {
	
	private String pno;
	private String pname;
	private String category;
	private Timestamp regdate;
	private String company;
	private int unit_price;
	private int sales_price;
	private String location;
	private int count;
	private String id;

}
