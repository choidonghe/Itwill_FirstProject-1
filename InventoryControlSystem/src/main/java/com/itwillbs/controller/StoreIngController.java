package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.StoreVO;
import com.itwillbs.service.StoreService;

@Controller
public class StoreIngController {
	
	@Inject
	private StoreService sService;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreIngController.class);
	
	@RequestMapping(value = "/storeinglist", method = RequestMethod.GET)
	public void storeIngListGET(Model model) throws Exception{

		logger.debug(" storeIngListGET() 실행 ");
		List<StoreVO> storeIngList = sService.storeIngGetList();
		logger.debug(" list.size() : " + storeIngList.size());
		logger.debug(" @!@!@!" + storeIngList);
		model.addAttribute("storeIngList", storeIngList);
		
	}
	
}
