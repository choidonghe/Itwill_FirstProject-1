package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.ReleaseVO;
import com.itwillbs.service.ReleaseService;

@Controller
@RequestMapping(value = "/release/*")
public class ReleaseController {
	
	@Inject
	private ReleaseService rService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ReleaseController.class);
	
	
	// http://localhost:8088/release/main
	
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public String Main(ReleaseVO vo,Model model) {
		logger.debug(" ReleaseMain() : +ReleaseMain()호출 ");
		
		List<ReleaseVO> List = rService.releaseList(vo);
		
		model.addAttribute("List", List);
		
		return "/release/main";
	}
	
	@RequestMapping(value = "/information",method = RequestMethod.GET)
	public void information(Model model,@RequestParam("divcode") int divcode, ReleaseVO vo) {
		logger.debug("information() 호출");
		
		logger.debug("divcode:" +divcode);
		
		List<ReleaseVO> infoList = rService.releaseInfoList(vo);
		
		model.addAttribute("infoList", infoList);
		
		
		
		
	}
	

}
