package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	private String pno;
	private String category_code;
	private String pname;
	private Timestamp regdate;
	private Timestamp update_date;
	private int unit_price;
	private String company;
	private int sales_price;
	private int divcode;
	private int count;
	private String account_code;
	private String warehouse_code;
	private int finish_count;
	private int remain_count;
	private String id;
	
	private List<CodeVO> codeVO;
	private List<WarehouseVO> warehouseVO;
}
