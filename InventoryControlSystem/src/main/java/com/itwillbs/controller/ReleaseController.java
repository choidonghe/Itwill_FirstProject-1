package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.CodeVO;
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
		List<CodeVO> code = rService.codeList();
		
		logger.debug("mainList:"+mainList);
		logger.debug("code:"+code);
		
		model.addAttribute("mainList", mainList);
		model.addAttribute("code", code);
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
		List<CodeVO> code =  rService.codeList();
		
		logger.debug("modifyList:"+modifyList);
		logger.debug("code:"+code);
		
		model.addAttribute("modifyList", modifyList);
		model.addAttribute("code", code);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ReleaseVO vo,Model model,String pno,Integer divcode, CodeVO code) throws Exception{
		logger.debug(" modifyPOST() 호출");
		
		logger.debug("vo:"+vo);
		logger.debug("divcode:"+divcode);
		logger.debug("code:"+code);
		
		  ReleaseVO inspectionList = rService.mainInspection(pno, divcode);
		    
		    logger.debug("inspectionList:" + inspectionList);
		    
		    model.addAttribute("inspectionList", inspectionList);
		
		
		rService.releaseModify(vo);

		return "redirect:/release/main";
	}
	
	@RequestMapping(value = "/information",method = RequestMethod.POST)
	public String removePOST(@RequestParam("pno") String pno) throws Exception{
		logger.debug("String removePOST() 호출");
		logger.debug("pno:"+pno);
		
		rService.releaseDelete(pno);
		
		
		return "redirect:/release/main";
		
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainInspectionPOST(String pno, int divcode, HttpSession session,Model model) throws Exception {
	    logger.debug("mainInspectionPOST() 호출");
	    
	    logger.debug("pno:" + pno);
	    logger.debug("divcode:" + divcode);
	    
	    ReleaseVO inspectionList = rService.mainInspection(pno, divcode);
	    
	    logger.debug("inspectionList:" + inspectionList);
	    
	    model.addAttribute("inspectionList", inspectionList);
	    
	    if(divcode == 5) {
	    	 return "redirect:/release/inspection"; 
	    } else if(divcode == 6) {
	    	return "redirect:/release/release";
	    }
	    
	    //session.setAttribute("inspectionList", inspectionList);
	    
	    return "redirect:/release/main";
	    
	    
	    
	}
	
	@RequestMapping(value = "/inspection", method = RequestMethod.GET)
	public void inspection(HttpSession session, Model model) throws Exception {
	   logger.debug("inspection() 호출");
	   
	   List<ReleaseVO> vo = rService.releaseList();
	   List<CodeVO> code = rService.codeList();
	   
	   model.addAttribute("vo", vo);
	   model.addAttribute("code", code);
	   
		/*
		 * ReleaseVO inspectionList = (ReleaseVO)
		 * session.getAttribute("inspectionList");
		 * 
		 * 
		 * model.addAttribute("inspectionList", inspectionList);
		 */
	}
	
	@RequestMapping(value = "/inspection", method = RequestMethod.POST)
	public String InspectionPOST(String pno, int divcode, HttpSession session,Model model,ReleaseVO vo) throws Exception {
	    logger.debug("mainInspectionPOST() 호출");
	    
	    logger.debug("pno:" + pno);
	    logger.debug("divcode:" + divcode);
	    
	    ReleaseVO inspectionList = rService.mainInspection(pno, divcode);
	    
	    logger.debug("inspectionList:" + inspectionList);
	    
	    model.addAttribute("inspectionList", inspectionList);
	    
	    if(divcode == 4) {
	    	return "redirect:/release/main";
	    } else if(divcode == 6) {
	      	return "redirect:/release/release";
	    }
	    
	    return "redirect:/release/release";
	    
	    //session.setAttribute("inspectionList", inspectionList);
	    
	    
	    
	}
	
	@RequestMapping(value = "/release", method = RequestMethod.GET)
	public void release(HttpSession session, Model model) throws Exception {
	   logger.debug("release() 호출");
	   
	   List<ReleaseVO> vo = rService.releaseList();
	   List<CodeVO> code = rService.codeList();
	   
	   model.addAttribute("vo", vo);
	   model.addAttribute("code", code);
	}
	
	
}
