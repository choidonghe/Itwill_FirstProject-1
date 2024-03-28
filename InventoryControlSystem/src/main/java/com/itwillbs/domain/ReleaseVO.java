package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

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
	private int release_count;
	private int error_count; 
    private String delivery_phone;
    private String delivery_manager;
    private int count;
    private String modify_id;
    private String release_id;

	private List<CodeVO> codeVO;
	private List<DeliveryVO> deliveryVO;
//	private List<WarehouseVO> warehouseVO;
}
