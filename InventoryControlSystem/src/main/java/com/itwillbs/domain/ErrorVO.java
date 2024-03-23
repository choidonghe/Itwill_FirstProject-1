package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ErrorVO {
	private String pno;
	private String pname;
	private	int divcode;
	private int count;
	private Timestamp regdate;
	private String warehouse_code;
	
	private List<WarehouseVO> warehouseVO;
}
