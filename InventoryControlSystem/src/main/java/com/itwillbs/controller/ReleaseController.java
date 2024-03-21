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
	public void Main(ReleaseVO vo,Model model) throws Exception {
		logger.debug(" ReleaseMain() 호출 ");
		
		List<ReleaseVO> List = rService.releaseList();
		
		model.addAttribute("List", List);
		

	}
	
	@RequestMapping(value = "/information",method = RequestMethod.GET)
	public void information(Model model,@RequestParam("divcode") int divcode, ReleaseVO vo) throws Exception {
		logger.debug("information() 호출");
		
		logger.debug("divcode:" +divcode);
		
		List<ReleaseVO> infoList = rService.releaseInfoList(vo);
		
		model.addAttribute("infoList", infoList);	
	}
	
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modify(@RequestParam("divcode") int divcode,Model model,ReleaseVO vo) throws Exception {
		logger.debug(" modify() 호출 ");
		
		logger.debug("divcode() 호출");
		
		List<ReleaseVO> modify = rService.releaseInfoList(vo);
		
		model.addAttribute("modify", modify);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(@RequestParam("divcode") int divcode, ReleaseVO vo) throws Exception {
		logger.debug("modify()POST");
		
		logger.debug("divcode:"+divcode);
		
		
		rService.releaseModify(vo);
		
		
		return "redirect:/release/main";
	}
	
	@RequestMapping(value = "/release",method = RequestMethod.GET)
	public void release(ReleaseVO vo,Model model) throws Exception{
		logger.debug("release() 호출");
		
		List<ReleaseVO> release = rService.releaseInfoList(vo);
		
		model.addAttribute("release", release);
	}
	@RequestMapping(value = "/release",method = RequestMethod.POST)
	public String releasePOST(ReleaseVO vo) throws Exception{
		logger.debug(" release()POST 호출");
		
		logger.debug("vo:"+ vo);
		
		rService.releaseCheck(vo);
		
		
		return "redirect:/release/main";
		
	}
	

	
	
	
	

}
