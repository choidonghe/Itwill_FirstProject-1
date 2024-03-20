package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.StoreVO;
import com.itwillbs.service.CodeService;
import com.itwillbs.service.StoreService;

@Controller
public class StoreIngController {
	
	@Inject
	private StoreService sService;
	@Inject
	private CodeService cService;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreIngController.class);
	
	@RequestMapping(value = "/storeinglist", method = RequestMethod.GET)
	public void storeIngListGET(Model model) throws Exception{

		logger.debug(" storeIngListGET() 실행 ");
		List<StoreVO> storeIngList = sService.storeIngGetList();
		List<CodeVO> codeList = cService.allCodeList();
		logger.debug(" list.size() : " + storeIngList.size());
		logger.debug(" @!@!@!" + storeIngList);
		model.addAttribute("storeIngList", storeIngList);
		model.addAttribute("codeList", codeList);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCode(StoreVO vo, String pno, Model model) throws Exception{
		model.addAttribute(sService.read(pno));
		logger.debug(" updateCode() 실행 ");
		logger.debug("pno : " + pno);
		logger.debug("vo : " + vo);
		sService.updateCode(vo);
		logger.debug("vo : " + vo);
		return "redirect:storeinglist";
	}
	
	
	
	
	
}
