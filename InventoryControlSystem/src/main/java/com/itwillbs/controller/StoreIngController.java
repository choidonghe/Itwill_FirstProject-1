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
import com.itwillbs.domain.ProductVO;
import com.itwillbs.service.CodeService;
import com.itwillbs.service.ProductService;

@Controller
public class StoreIngController {
	
	@Inject
	private CodeService cService;
	@Inject
	private ProductService pService;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreIngController.class);
	
	@RequestMapping(value = "/storeinglist", method = RequestMethod.GET)
	public void storeIngListGET(Model model) throws Exception{

		logger.debug(" storeIngListGET() 실행 ");
		List<ProductVO> productList = pService.productGetList();
		List<CodeVO> codeList = cService.allCodeList();
		logger.debug(" list.size() : " + productList.size());
		logger.debug(" @!@!@!" + productList);
		model.addAttribute("productList", productList);
		model.addAttribute("codeList", codeList);
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
	
	
	
	
	
}
