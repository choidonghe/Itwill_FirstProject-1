package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.EmergencyOrderVO;
import com.itwillbs.domain.ErgOrderCriteria;
import com.itwillbs.domain.NoticeCriteria;
import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.ProductVO;

public interface MainService {
	
	public List<String> sellTotalGet() throws Exception;
	
	public List<String> dayListGet() throws Exception;
	
	public List<String> releaseListGet() throws Exception;

	public List<String> storeListGet() throws Exception;
	
	public int getOrderListCount() throws Exception;
	
	public List<EmergencyOrderVO> ergOrederGet(ErgOrderCriteria cri) throws Exception;
	
	public int getNoticeListCount() throws Exception;
	
	public List<NoticeVO> noListGet(NoticeCriteria cri) throws Exception;
	
	public int searchNoCount() throws Exception;
	
	public List<NoticeVO> searchNoListGet(NoticeCriteria cri, String search) throws Exception;
	
	public void noticeWrite(NoticeVO vo)throws Exception;
	
	public NoticeVO noticeGet(String bno)throws Exception;
	
	public List<ProductVO> productDayGet(String startStr) throws Exception;
	
}// service
