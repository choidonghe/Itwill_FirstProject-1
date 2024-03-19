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
		
		return sql.selectList(NAMESPACE+".getReleaseMonth", month );
	}
	
	
	
	
	
	
}// daoImpl
