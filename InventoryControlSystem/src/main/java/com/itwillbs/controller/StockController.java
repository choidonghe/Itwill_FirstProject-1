package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageVO;
import com.itwillbs.domain.StockVO;
import com.itwillbs.service.StockService;

@Controller
@RequestMapping(value = "/stock/*")
public class StockController {
	@Inject
	private StockService sService;
	
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
		
	// 재고 리스트 페이징처리
	// http://localhost:8088/stock/stockMainCri
	// 실제로 사용하게 될 주소
	// http://localhost:8088/stock/stockMainCri?page=1&pageSize=10
	@RequestMapping(value = "/stockMainCri", method = RequestMethod.GET)
	public void listCriGET(Criteria cri, Model model, HttpSession session) throws Exception {
		logger.debug(" /stock/stockMainCri -> listCriGET() 실행 ");
		logger.debug(" /stock/stockMainCri.jsp 연결 ");
		
		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(sService.getBoardListCount(cri));
		
		List<StockVO> stockList = sService.getListCri(cri); // 페이징
		logger.debug(" list.size : " + stockList.size());
		logger.debug("키워드 : " + cri.getKeyword());
		logger.debug("타입 : " + cri.getType());
		logger.debug("cri toString : " + cri.toString());
		logger.debug("pageVO의 listcount : "+ pageVO.getTotalCount());
		logger.debug("s.Service의 listcount : " + sService.getBoardListCount(cri));
		// 연결된 뷰페이지에 정보 전달(Model)
		model.addAttribute("stockList", stockList);
		model.addAttribute("cri", cri);
		model.addAttribute("pageVO", pageVO);
		
		
		// return "redirect:/stock/stockMainCri?page="+cri.getPage()+"&pageSize="+cri.getPageSize();
	}
	
	

}
