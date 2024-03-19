package com.itwillbs.domain;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class StockVO {

	private String pno;
	private String warehouse_code;
	private int count;
	private String pname;
	private String company;
	private String category;
		

}

