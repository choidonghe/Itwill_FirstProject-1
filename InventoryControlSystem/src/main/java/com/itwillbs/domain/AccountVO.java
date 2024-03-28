package com.itwillbs.domain;

import lombok.Data;

@Data
public class AccountVO {
	private String account_code;
    private String account_name;
    private String account_manager;
    private String account_phone;
    private String account_addr;
    private String account_explain;
}
