package com.itwillbs.persistence;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.EmergencyOrderVO;
import com.itwillbs.domain.ErgOrderCriteria;
import com.itwillbs.domain.NoticeCriteria;
import com.itwillbs.domain.NoticeVO;

@Repository
public class MainDAOImpl implements MainDAO {

	@Inject
 	private SqlSession sql;
	
	private static final Logger logger = LoggerFactory.getLogger(MainDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MainMapper";
	
	
	
	

	@Override
	public String getTodayMonth() throws Exception {
		logger.debug(" getTodayMonth() 호출");
		
		Date today = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String month = dateFormat.format(today);
		
		logger.debug(" todayMonth : "+month);
		
		return month;
	}

	@Override
	public List<String> getDayList() throws Exception {
		logger.debug(" getDayList() 호출");
		
		List<String> dayList = new ArrayList<String>();
		
//		Date today = new Date();
//		logger.debug("today : "+today);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		for(int i = 0; i < 5; i++ ){
			
		Calendar c1 = Calendar.getInstance(); 
	    c1.add(Calendar.DATE, -i);
	    
	    dayList.add(dateFormat.format(c1.getTime()));
		
		}
		
		logger.debug("날짜 : "+dayList.toString());
		
		return dayList;
		
	}

	@Override
	public String getSellTotal(String date) throws Exception {
		logger.debug(" getSellTotal(String date) 실행");
		
		return sql.selectOne(NAMESPACE+".getSellTotal", date);
		
	}

	@Override
	public List<String> getReleaseDay(String month) throws Exception {
		logger.debug(" getReleaseDay(String month) 실행 : "+month);
		
		List<String> list = sql.selectList(NAMESPACE+".getReleaseMonth", month );
		List<String> newList = new ArrayList<String>();
		
		if(!list.isEmpty()) {
			
			for(int i = 0; i<list.size(); i++) {
				String pDay =  "'"+list.get(i)+"'";
				logger.debug("pDay"+pDay);
				newList.add(pDay);
			}
			
		}
		logger.debug("newList"+newList);
		return newList;
	}

	@Override
	public List<String> getStoreDay(String month) throws Exception {
		logger.debug(" getStoreDay(String month) 실행 : "+month);
		
		List<String> list = sql.selectList(NAMESPACE+".getStoreMonth", month );
		List<String> newList = new ArrayList<String>();
		
		if(!list.isEmpty()) {
			
			for(int i = 0; i<list.size(); i++) {
				String pDay =  "'"+list.get(i)+"'";
				logger.debug("pDay"+pDay);
				newList.add(pDay);
			}
			
		}
		logger.debug("newList"+newList);
		return newList;
	}
	
	@Override
	public List<EmergencyOrderVO> ergOrder(ErgOrderCriteria cri) throws Exception {
		logger.debug(" ergOrder() 호출 ");
		
		return sql.selectList(NAMESPACE+".ergOrder",cri);
		
	}

	@Override
	public int boardCount() throws Exception {
		logger.debug(" boardCount() 호출 ");
		
		return sql.selectOne(NAMESPACE+".orderTotalCount");
	}

	@Override
	public int noticeCount() throws Exception {
		logger.debug(" noticeCount() 호출 ");
		
		return sql.selectOne(NAMESPACE+".noticeTotalCount");
	}

	@Override
	public List<NoticeVO> noticeBoard(NoticeCriteria cri) throws Exception {
		logger.debug(" noticeBoard(MainCriteria cri) 호출 ");
		
		return sql.selectList(NAMESPACE+".noticeList", cri);
	}

	@Override
	public List<NoticeVO> searchNoticeBoard(NoticeCriteria cri, String search) throws Exception {
		logger.debug(" searchNoticeBoard(NoticeCriteria cri) 호출");
		logger.debug(" search : "+search);
		
		return sql.selectList(NAMESPACE+".searchNoticeList", search);
	}
	
	
	@Override
	public int getNoticeBno() throws Exception {
		logger.debug(" getNoticeBno() 호출 ");
		
		return sql.selectOne(NAMESPACE+".getNoticeBno");
	}

	@Override
	public void writeNotice(NoticeVO vo) throws Exception {
		logger.debug(" insertNotice(NoticeVO vo) 호출 ");
		
		sql.insert(NAMESPACE+".insertNotice", vo);
	}
	
	
	
	
	
}// daoImpl
