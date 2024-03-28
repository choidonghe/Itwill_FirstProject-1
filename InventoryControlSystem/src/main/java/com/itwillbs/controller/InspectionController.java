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

import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.StorePageVO;
import com.itwillbs.domain.WarehouseVO;
import com.itwillbs.service.CodeService;
import com.itwillbs.service.InspectionService;
import com.itwillbs.service.ProductService;

@Controller
@RequestMapping(value = "/inspec/*")
public class InspectionController {
	
	@Inject
	private InspectionService iService;
	@Inject
	private CodeService cService;
	@Inject
	private ProductService pService;
	private static final Logger logger = LoggerFactory.getLogger(InspectionController.class);
	
	// 입고 검수 메인 페이지
	// http://localhost:8088/inspec/inspectionMain
	@RequestMapping(value = "/inspectionMain", method = RequestMethod.GET)
	public void inspectionMain(Model model, Criteria cri) throws Exception{
		logger.debug(" inspectionMain() 실행 ");
		StorePageVO spageVO = new StorePageVO();
		spageVO.setCri(cri);
		spageVO.setTotalCount(iService.countInspec());
		List<ProductVO> inspectionList = iService.inspecGetListCri(cri);
		List<CodeVO> codeList = cService.allCodeList();
		List<WarehouseVO> warehouseList = iService.warehouseList();
		
		logger.debug("inspectionList : " + inspectionList);
		logger.debug("warehouseList : " + warehouseList);
		logger.debug(" list.size() : " + inspectionList.size());
		logger.debug(" spageVO : " + spageVO);
		model.addAttribute("inspectionList", inspectionList);
		model.addAttribute("warehouseList", warehouseList);
		model.addAttribute("codeList", codeList);
		model.addAttribute("spageVO", spageVO);
		model.addAttribute("cri", cri);
	}
	
	// 검수 본문 페이지 GET
	@RequestMapping(value = "/inspectionRead", method = RequestMethod.GET)
	public void inspectionReadGET(String pno, Model model, HttpSession session) throws Exception{
		logger.debug(" inspectionReadGET() 호출 ");
		logger.debug(" pno : "+pno);
		List<WarehouseVO> warehouseList = iService.warehouseList();
		logger.debug(" warehouseList : "+warehouseList);
		ProductVO vo = iService.productRead(pno);
		logger.debug(" vo " + vo);
		model.addAttribute("vo", vo);
		model.addAttribute("warehouseList", warehouseList);
	}
	
	// 검수 본문 업데이트 POST
	@RequestMapping(value = "/inspectionRead", method = RequestMethod.POST)
	public String inspectionReadPOST(String pno,int divcode, Model model,ProductVO pvo) throws Exception{
		logger.debug(" inspectionReadPOST() 호출 ");
		ProductVO vo = iService.productRead(pno);
		logger.debug(" vo " + vo);
		if(divcode == 3) {
			try {
				iService.productModify(pvo);
				iService.productUpdateRemain(pvo);
			}
			catch (Exception e) {
				logger.debug(" 이미 중복 ");
				iService.updateStock(pvo);
				iService.productUpdateRemain(pvo);
			}
		}
		
		if(divcode == 7) {
			try {
				logger.debug(" vo " + vo);
				logger.debug("불량");
				iService.insertError(pvo);
				iService.productUpdateRemain(pvo);
				iService.updateError(pvo);
			} catch (Exception e) {
				logger.debug(" 이미 중복 ");
				iService.updateError(pvo);
				iService.productUpdateRemain(pvo);
			}
		}
		
		
		return "redirect:/inspec/inspectionMain";
	}
	
	// 검수 상태별 페이지 (미검수)
	// http://local:8088/inspec/inspectionDiv2
	@RequestMapping(value = "/inspectionDiv2", method = {RequestMethod.GET, RequestMethod.POST})
	public void inspectionDiv2(Model model, Criteria cri) throws Exception{
		logger.debug(" inspectionDiv2() 호출 ");
		StorePageVO spageVO = new StorePageVO();
		spageVO.setCri(cri);
		spageVO.setTotalCount(iService.countInspec());		
		List<ProductVO> inspectionList = iService.productGetInspectionCri2(cri);
		List<CodeVO> codeList = cService.allCodeList();
		model.addAttribute("inspectionList",inspectionList);
		model.addAttribute("cri", cri);
		model.addAttribute("spageVO", spageVO);
		model.addAttribute("codeList", codeList);
	}
	
	// 검수 상태별 페이지 (검수완)
	// http://local:8088/inspec/inspectionDiv3
	@RequestMapping(value = "/inspectionDiv3", method = {RequestMethod.GET, RequestMethod.POST})
	public void inspectionDiv3(Model model, Criteria cri) throws Exception{
		logger.debug(" inspectionDiv3() 호출 ");
		StorePageVO spageVO = new StorePageVO();
		spageVO.setCri(cri);
		spageVO.setTotalCount(iService.countInspec());
		List<ProductVO> stockList = iService.productGetInspectionCri3(cri);
		List<CodeVO> codeList = cService.allCodeList();
		model.addAttribute("stockList",stockList);
		model.addAttribute("codeList",codeList);
		model.addAttribute("cri", cri);
		model.addAttribute("spageVO", spageVO);		
	}
	
	
	// 검수 상태별 페이지 (불량제품)
	// http://local:8088/inspec/inspectionDiv4
	@RequestMapping(value = "/inspectionDiv4", method = RequestMethod.POST)
	public void inspectionDiv4(Model model,Criteria cri) throws Exception{
		logger.debug(" inspectionDiv4() 호출 ");
		StorePageVO spageVO = new StorePageVO();
		spageVO.setCri(cri);
		spageVO.setTotalCount(iService.countInspec());
		List<ErrorVO> errorList = iService.errorCri(cri);
		List<WarehouseVO> warehouseList = iService.warehouseList();
		List<CodeVO> codeList = cService.allCodeList();
		model.addAttribute("errorList",errorList);
		model.addAttribute("warehouseList", warehouseList);
		model.addAttribute("cri", cri);
		model.addAttribute("spageVO", spageVO);
		model.addAttribute("codeList", codeList);
	}
	
}
