package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class StoreVO {
	private int divcode;
	private String pno;
	private String pname;
	private int count;
	private String category;
	private int price;
	private Timestamp store_date;
	private Timestamp update_date;
	private String account_code;
	
	private List<CodeVO> codeVO;
	
}
