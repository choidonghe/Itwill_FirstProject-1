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
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageVO;
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
	public void main(Criteria cri, Model model) throws Exception{
		logger.debug("main() 호출");
		// 페이징 처리 객체
				//Criteria cri = new Criteria();
				//cri.setPageSize(20);
				PageVO pageVO = new PageVO();
				pageVO.setCri(cri);
				//pageVO.setTotalCount(3840); // 총 개수 직접 계산
				pageVO.setTotalCount(rService.getReleaseListCount()); // SQL 구문 계산
				
				
				// 서비스 -> DAO 게시판 글 목록 가져오기
				//List<BoardVO> boardList = bService.getList(); //all
				List<ReleaseVO> mainList = rService.getListCri(cri); //페이징
				logger.debug("list.size :" +mainList.size());
				
				List<CodeVO> code = rService.codeList();
				
				// 연결된 뷰 페이지에 정보 전달
				model.addAttribute("mainList", mainList);
				
				model.addAttribute("cri", cri); // 페이징 처리 정보 전달
				
				model.addAttribute("pageVO", pageVO); // 페이징 처리 정보 전달
				
				model.addAttribute("code", code);
				
				
				
				
		
	}
	
	@RequestMapping(value = "information",method = RequestMethod.GET)
	public void information(String pno,Model model,Criteria cri) throws Exception{
		logger.debug("informatino() 호출");
		
		logger.debug("pno:"+pno);
		
		ReleaseVO infoList = rService.releaseInfoList(pno);
		logger.debug("infoList:"+infoList);
		
		model.addAttribute("infoList", infoList);
		
		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(rService.getReleaseListCount()); 
		
		model.addAttribute("cri", cri); // 페이징 처리 정보 전달
		
		model.addAttribute("pageVO", pageVO); // 페이징 처리 정보 전달

	}
	
	@RequestMapping(value = "modify",method = RequestMethod.GET)
	public void modify(String pno,Model model,Criteria cri) throws Exception{
		logger.debug("modify() 호출");
		
		logger.debug("pno:"+pno);
		
		ReleaseVO modifyList = rService.releaseInfoList(pno);
		List<CodeVO> code =  rService.codeList();
		
		logger.debug("modifyList:"+modifyList);
		logger.debug("code:"+code);
		
		model.addAttribute("modifyList", modifyList);
		model.addAttribute("code", code);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ReleaseVO vo,Model model,String pno,Integer divcode, CodeVO code,Criteria cri) throws Exception{
		logger.debug(" modifyPOST() 호출");
		
		logger.debug("vo:"+vo);
		logger.debug("divcode:"+divcode);
		logger.debug("code:"+code);
		
		  ReleaseVO inspectionList = rService.mainInspection(pno, divcode);
		    
		    logger.debug("inspectionList:" + inspectionList);
		    
		    model.addAttribute("inspectionList", inspectionList);
		
		
		rService.releaseModify(vo);

		return "redirect:/release/main?page="+cri.getPage()+"&pageSize="+cri.getPageSize();
	}
	
	@RequestMapping(value = "/information",method = RequestMethod.POST)
	public String removePOST(@RequestParam("pno") String pno,Criteria cri) throws Exception{
		logger.debug("String removePOST() 호출");
		logger.debug("pno:"+pno);
		
		rService.releaseDelete(pno);
		
		
		return "redirect:/release/main?page="+cri.getPage()+"&pageSize="+cri.getPageSize();
		
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
	public void inspection(HttpSession session, Model model,Criteria cri) throws Exception {
	   logger.debug("inspection() 호출");

	// 페이징 처리 객체
		//Criteria cri = new Criteria();
		//cri.setPageSize(20);
		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		//pageVO.setTotalCount(3840); // 총 개수 직접 계산
		pageVO.setTotalCount(rService.getReleaseListCount()); // SQL 구문 계산
		
		
		// 서비스 -> DAO 게시판 글 목록 가져오기
		//List<BoardVO> boardList = bService.getList(); //all
		List<ReleaseVO> vo = rService.getListCri(cri); //페이징
		logger.debug("list.size :" +vo.size());
		
		List<CodeVO> code = rService.codeList();
		
		// 연결된 뷰 페이지에 정보 전달
		model.addAttribute("vo", vo);
		
		model.addAttribute("cri", cri); // 페이징 처리 정보 전달
		
		model.addAttribute("pageVO", pageVO); // 페이징 처리 정보 전달
		
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
	public String InspectionPOST(String pno, int divcode, HttpSession session,Model model,ReleaseVO vo,Integer order_count,Integer release_count) throws Exception {
	    logger.debug("mainInspectionPOST() 호출");
	    logger.debug("order_count:"+order_count);
	    logger.debug("release_count:"+release_count);
	    
	    logger.debug("pno:" + pno);
	    logger.debug("divcode:" + divcode);
	    
	    ReleaseVO inspectionList = rService.mainInspection(pno, divcode);
	    
	    logger.debug("inspectionList:" + inspectionList);
	    
	    model.addAttribute("inspectionList", inspectionList);
	    
	    ReleaseVO subtract = rService.releaseSubtract(pno, release_count);
//	    ReleaseVO error = rService.releaseError(pno, release_count, error_count);
	    
	    
	    logger.debug("subtract:"+subtract);
	    
		if(divcode == 6) {
			logger.debug("subtract -> " + subtract);
			
			model.addAttribute("subtract", subtract);
			
			return "redirect:/release/release";
		}
		    
	    return "redirect:/release/release";
	    
	    //session.setAttribute("inspectionList", inspectionList);
	    
	    
	    
	}
	
	@RequestMapping(value = "/release", method = RequestMethod.GET)
	public void release(HttpSession session, Model model,Criteria cri) throws Exception {
	   logger.debug("release() 호출");
	   
	// 페이징 처리 객체
			//Criteria cri = new Criteria();
			//cri.setPageSize(20);
			PageVO pageVO = new PageVO();
			pageVO.setCri(cri);
			//pageVO.setTotalCount(3840); // 총 개수 직접 계산
			pageVO.setTotalCount(rService.getReleaseListCount()); // SQL 구문 계산
			
			
			// 서비스 -> DAO 게시판 글 목록 가져오기
			//List<BoardVO> boardList = bService.getList(); //all
			List<ReleaseVO> vo = rService.getListCri(cri); //페이징
			logger.debug("list.size :" +vo.size());
			
			List<CodeVO> code = rService.codeList();
			
			// 연결된 뷰 페이지에 정보 전달
			model.addAttribute("vo", vo);
			
			model.addAttribute("cri", cri); // 페이징 처리 정보 전달
			
			model.addAttribute("pageVO", pageVO); // 페이징 처리 정보 전달
			
			model.addAttribute("code", code);
		
	}
	
	
}
