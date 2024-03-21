package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.EmergencyOrderVO;
import com.itwillbs.domain.MainCriteria;
import com.itwillbs.domain.NoticeVO;

public interface MainService {
	
	public List<String> sellTotalGet() throws Exception;
	
	public List<String> dayListGet() throws Exception;
	
	public List<String> releaseListGet() throws Exception;

	public List<String> storeListGet() throws Exception;
	
	public int getOrderListCount() throws Exception;
	
	public List<EmergencyOrderVO> ergOrederGet(MainCriteria cri) throws Exception;
	
	public int getNoticeListCount() throws Exception;
	
	public List<NoticeVO> noListGet(MainCriteria cri) throws Exception;
	
	
}// service
