package com.itwillbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.EmergencyOrderVO;
import com.itwillbs.domain.ErgOrderCriteria;
import com.itwillbs.domain.NoticeCriteria;
import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.ReleaseVO;
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

	@Override
	public List<EmergencyOrderVO> ergOrederGet(ErgOrderCriteria cri) throws Exception {
		logger.debug(" ergOrederGet() 호출");
		
		return mdao.ergOrder(cri);
	}


	@Override
	public int getOrderListCount() throws Exception {
		logger.debug(" getOrderListCount() 호출 ");
		
		return mdao.boardCount();
	}


	@Override
	public int getNoticeListCount() throws Exception {
		logger.debug(" getNoticeListCount() 호출");
		
		return mdao.noticeCount();
	}


	@Override
	public List<NoticeVO> noListGet(NoticeCriteria cri) throws Exception {
		logger.debug(" noListGet(MainCriteria Cri) 호출 ");
		
		return mdao.noticeBoard(cri);
	}

	
	

	@Override
	public int searchNoCount() throws Exception {
		logger.debug(" searchNoCount() 호출 ");
		
		return mdao.serchNoticeCount();
	}


	@Override
	public List<NoticeVO> searchNoListGet(NoticeCriteria cri, String search) throws Exception {
		logger.debug("  searchNoListGet(NoticeCriteria cri) 호출");
		
		return mdao.searchNoticeBoard(cri, search);
	}


	@Override
	public void noticeWrite(NoticeVO vo) throws Exception {
		logger.debug(" noticeWrite(NoticeVO vo) 호출");
		vo.setBno(mdao.getNoticeBno()+1);
		mdao.writeNotice(vo);
		
		logger.debug(" 글쓰기 완료 ");
	}
	
	@Override
	public NoticeVO noticeGet(String bno) throws Exception {
		logger.debug(" noticeGet(String bno) 실행");
		
		return mdao.getContent(bno);
	}


	@Override
	public List<ProductVO> productDayGet(String startStr) throws Exception {
		logger.debug(" productDayGet(String startStr) 실행");
	
		return mdao.getProductDay(startStr);
	}


	@Override
	public List<ReleaseVO> releaseDayGet(String startStr) throws Exception {
		logger.debug(" releaseDayGet(String startStr) 실행");
		
		return mdao.getReleaseDayList(startStr);
	}
	
	
	
	
	

	
}// serviceImpl
