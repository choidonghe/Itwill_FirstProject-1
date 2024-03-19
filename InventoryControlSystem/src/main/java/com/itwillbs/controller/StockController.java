package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.StockVO;
import com.itwillbs.service.StockService;

@Controller
@RequestMapping(value = "/stock/*")
public class StockController {
	@Inject
	private StockService sService;
	
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	// 재고 리스트 GET : /stock/stockMain
	// http://localhost:8088/stock/stockMain
	@RequestMapping(value = "/stockMain", method = RequestMethod.GET)
	public void listGET(Model model, HttpSession session) throws Exception {
		logger.debug(" /stock/stockMain -> listGET() 실행 ");
		logger.debug(" /stock/stockMain.jsp 연결 ");
		// 서비스 -> DAO 재고 목록 가져오기
		List<StockVO> stockList = sService.getList();
		logger.debug(" list.size : " + stockList.size());
		// 연결된 뷰 페이지에 정보 전달 (Model)
		model.addAttribute("stockList", stockList);
		
	}
	
	

}
