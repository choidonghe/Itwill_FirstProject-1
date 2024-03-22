package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.service.CodeService;
import com.itwillbs.service.InspectionService;

@Controller
@RequestMapping(value = "/inspec/*")
public class InspectionController {
	
	@Inject
	private InspectionService iService;
	@Inject
	private CodeService cService;
	
	private static final Logger logger = LoggerFactory.getLogger(InspectionController.class);
	
	// 입고 검수 메인 페이지
	// http://localhost:8088/inspec/inspectionMain
	@RequestMapping(value = "/inspectionMain", method = RequestMethod.GET)
	public void inspectionMain(Model model) throws Exception{
		logger.debug(" inspectionMain() 실행 ");
		List<ProductVO> inspectionList = iService.productGetInspectionList();
		List<CodeVO> codeList = cService.allCodeList();
		logger.debug("inspectionList : " + inspectionList);
		model.addAttribute("inspectionList", inspectionList);
		model.addAttribute("codeList", codeList);
	}
	
	// 검수 본문 페이지 GET
	@RequestMapping(value = "/inspectionRead", method = RequestMethod.GET)
	public void inspectionReadGET(String pno, Model model, HttpSession session) throws Exception{
		logger.debug(" inspectionReadGET() 호출 ");
		logger.debug(" pno : "+pno);
		ProductVO vo = iService.productRead(pno);
		model.addAttribute("vo", vo);
	}
	
	// 검수 본문 업데이트 POST
	@RequestMapping(value = "/inspectionRead", method = RequestMethod.POST)
	public String inspectionReadPOST(String pno, Model model,ProductVO pvo) throws Exception{
		logger.debug(" inspectionReadPOST() 호출 ");
		iService.productModify(pvo);
		iService.productUpdateRemain(pvo);
		return "redirect:/inspec/inspectionMain";
	}
	
	// 검수 상태별 페이지 (미검수)
	// http://local:8088/inspec/inspectionDiv2
	@RequestMapping(value = "/inspectionDiv2", method = RequestMethod.POST)
	public void inspectionDiv2(Model model) throws Exception{
		logger.debug(" inspectionDiv2() 호출 ");
		List<ProductVO> inspectionList = iService.productGetInspectionDiv2();
		model.addAttribute("inspectionList",inspectionList);
	}
	
	// 검수 상태별 페이지 (검수완)
	// http://local:8088/inspec/inspectionDiv3
	@RequestMapping(value = "/inspectionDiv3", method = RequestMethod.POST)
	public void inspectionDiv3(Model model) throws Exception{
		logger.debug(" inspectionDiv3() 호출 ");
		List<ProductVO> inspectionList = iService.productGetInspectionDiv3();
		model.addAttribute("inspectionList",inspectionList);
	}
	
}
