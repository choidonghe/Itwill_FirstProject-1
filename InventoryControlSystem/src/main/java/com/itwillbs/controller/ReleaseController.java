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
	
	@RequestMapping(value = "main",method = RequestMethod.GET)
	public void main(Model model) throws Exception{
		logger.debug("main() 호출");
		
		List<ReleaseVO> mainList = rService.releaseList();
		
		model.addAttribute("mainList", mainList);
	}
	
	@RequestMapping(value = "information",method = RequestMethod.GET)
	public void information(String pno,Model model) throws Exception{
		logger.debug("informatino() 호출");
		
		logger.debug("pno:"+pno);
		
		ReleaseVO infoList = rService.releaseInfoList(pno);
		logger.debug("infoList:"+infoList);
		
		model.addAttribute("infoList", infoList);
	}
	
	@RequestMapping(value = "modify",method = RequestMethod.GET)
	public void modify(String pno,Model model) throws Exception{
		logger.debug("modify() 호출");
		
		logger.debug("pno:"+pno);
		
		ReleaseVO modifyList = rService.releaseInfoList(pno);
		logger.debug("modifyList:"+modifyList);
		
		model.addAttribute("modifyList", modifyList);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ReleaseVO vo,Model model,String pno) throws Exception{
		logger.debug(" modifyPOST() 호출");
		
		logger.debug("vo:"+vo);
		
		rService.releaseModify(vo);
		
		return "redirect:/release/main";
	}

}
