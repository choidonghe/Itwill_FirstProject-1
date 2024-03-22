package com.itwillbs.persistence;

import java.util.Date;
import java.util.List;

import com.itwillbs.domain.EmergencyOrderVO;
import com.itwillbs.domain.ErgOrderCriteria;
import com.itwillbs.domain.NoticeCriteria;
import com.itwillbs.domain.NoticeVO;

public interface MainDAO {
	
	public String getTodayMonth() throws Exception;
	
	public List<String> getDayList() throws Exception;
	
	public String getSellTotal(String date) throws Exception;
	
	public List<String> getReleaseDay(String month) throws Exception;

	public List<String> getStoreDay(String month) throws Exception;	
	
	public int boardCount() throws Exception;
	
	public List<EmergencyOrderVO> ergOrder(ErgOrderCriteria cri) throws Exception;
	
	public int noticeCount() throws Exception;
	
	public List<NoticeVO> noticeBoard(NoticeCriteria cri) throws Exception;
	
	public int serchNoticeCount() throws Exception;

	public List<NoticeVO> searchNoticeBoard(NoticeCriteria cri, String search) throws Exception;
	
	public int getNoticeBno() throws Exception;
	
	public void writeNotice(NoticeVO vo) throws Exception;
	
}// dao
