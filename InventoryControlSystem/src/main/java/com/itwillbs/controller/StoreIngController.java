package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.AccountVO;
import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.MemberVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.StorePageVO;
import com.itwillbs.service.AccountService;
import com.itwillbs.service.CodeService;
import com.itwillbs.service.ProductService;

@Controller
public class StoreIngController {
	
	@Inject
	private CodeService cService;
	@Inject
	private ProductService pService;
	@Inject
	private AccountService aService;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreIngController.class);
	
	//http://localhost:8088/storeinglist
	@RequestMapping(value = "/storeinglist", method = RequestMethod.GET)
	public void storeIngListGET(Criteria cri, Model model, MemberVO vo) throws Exception{

		logger.debug(" storeIngListGET() 실행 ");
		StorePageVO spageVO = new StorePageVO();
		spageVO.setCri(cri);
		spageVO.setTotalCount(pService.getProductListCount());
		
		//List<ProductVO> productList = pService.productGetList();
		List<ProductVO> productList = pService.productGetListCri(cri);
		//List<ProductVO> productListPage = pService.productListPaget(1);
		List<CodeVO> codeList = cService.allCodeList();
		
		
		
		logger.debug(" list.size() : " + productList.size());
		logger.debug(" @!@!@!" + productList);
		logger.debug("spageVO : " + spageVO);
		model.addAttribute("productList", productList);
		model.addAttribute("cri", cri);
		model.addAttribute("spageVO", spageVO);
		model.addAttribute("codeList", codeList);
		
		//model.addAttribute("productListPage", productListPage);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCode(ProductVO pvo, String pno, Model model) throws Exception{
		model.addAttribute(pService.pRead(pno));
		logger.debug(" updateCode() 실행 ");
		logger.debug("pno : " + pno);
		logger.debug("vo : " + pvo);
		pService.updateProductCode(pvo);
		pService.insertInspection(pvo);
		logger.debug("vo : " + pvo);
		return "redirect:storeinglist";
	}
	 
	@RequestMapping(value = "/insertPro", method = RequestMethod.GET)
	public void registerGET(Model model, AccountVO avo) throws Exception{
		logger.debug(" registerGET() 호출 ");
		List<AccountVO> aList = aService.aList(avo);
		model.addAttribute("aList", aList);
	}
	
	@RequestMapping(value = "/insertPro", method = RequestMethod.POST)
	public String registerPOST(ProductVO pvo) throws Exception{
		logger.debug(" 전달정보 : " + pvo);
		pService.insertProduct(pvo);
		return "redirect:/storeinglist";
	}
	
}
