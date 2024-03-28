package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class WarehouseVO {
	private String warehouse_code;
	private String category_code;
	private String location;
	private String pname;
	private int capacity;
	private String manager;
	private Timestamp regdate;
	private Timestamp update_date;
	
}
