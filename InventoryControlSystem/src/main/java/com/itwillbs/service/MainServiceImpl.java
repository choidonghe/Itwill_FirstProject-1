package com.itwillbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);


	@Override
	public List<String> sellTotalGet() throws Exception {
		logger.debug(" sellTotalGet() 호출");
		
		List<String> dList = new ArrayList<String>();
		
		for(String date:mdao.getDayList()) {
			
			dList.add(mdao.getSellTotal(date));
		}
		logger.debug(" dList : "+dList);
		
		return dList;
	}


	@Override
	public List<String> dayListGet() throws Exception {
		logger.debug(" dayListGet() 호출");
		
		return mdao.getDayList();
		
	}


	@Override
	public List<String> releaseListGet() throws Exception {
		logger.debug(" releaseListGet() 호출");
		
		return mdao.getReleaseDay(mdao.getTodayMonth());
		
	}


	@Override
	public List<String> storeListGet() throws Exception {
		logger.debug(" storeListGet() 호출");
		
		return mdao.getStoreDay(mdao.getTodayMonth());
	}

	
	
	
	
}// serviceImpl
