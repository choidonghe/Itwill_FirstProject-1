package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class InspectionVO {
	
	private String pno;
	private String id;
	private int divcode;
	private int quantity;
	private int finish_quantity;
	private int remain_quantity;
	private Timestamp regdate;
	private Timestamp update_date;
	private String warehouse_code;
	
	
}
