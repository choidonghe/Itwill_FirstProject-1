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
	private String warehouse_code; // 동희형 필요없음
	private int error_count; // 동희형 추가
	
	private List<WarehouseVO> warehouseVO;
	private List<CodeVO> codeVO;
}
