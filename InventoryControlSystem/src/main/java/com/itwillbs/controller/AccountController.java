package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.AccountVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.StorePageVO;
import com.itwillbs.service.AccountService;

@Controller
@RequestMapping(value = "/account/*")
public class AccountController { 
	
	@Inject
	private AccountService aService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	// 거래처 관리 페이지 
	@RequestMapping(value = "/accountMain", method = RequestMethod.GET)
	public void accountMain(Criteria cri, Model model) throws Exception{
		logger.debug(" account() 호출 ");
		StorePageVO spageVO = new StorePageVO();
		spageVO.setCri(cri);
		spageVO.setTotalCount(aService.accountCount());
		List<AccountVO> accountList = aService.accountListCri(cri);
		logger.debug(" 11 accountList : " + accountList);
		logger.debug(" spageVO : " + spageVO);
		model.addAttribute("accountList", accountList);
		model.addAttribute("spageVO", spageVO);
		model.addAttribute("cri", cri);
	}
	
	// 거래처 본문 페이지 GET
	@RequestMapping(value = "/accountRead", method = RequestMethod.GET)
	public void accountReadGET(String account_code, Model model, HttpSession session) throws Exception{
		logger.debug(" accountReadGET() 호출 ");
		logger.debug(" account_code : " + account_code);
		AccountVO avo = aService.accountRead(account_code);
		model.addAttribute("avo", avo);
	}
	
	// 거래처 본문 페이지 POST
	@RequestMapping(value = "/accountRead", method = RequestMethod.POST)
	public String accountReadPOST(String account_code, Model model, AccountVO avo) throws Exception{
		logger.debug(" accountReadPOST() 호출 ");
		aService.accountUpdate(avo);
		return "redirect:/account/accountMain";
	}
	
	// 거래처 삭제 페이지 POST
	@PostMapping("/accountDelete")
	public String accountDelete(String account_code, RedirectAttributes redirectAttributes) throws Exception{
		logger.debug(" accountDelete() 호출 ");
		aService.accountDelete(account_code);
		redirectAttributes.addFlashAttribute("successMessage", "계정이 성공적으로 삭제되었습니다.");
		return "redirect:/account/accountMain";
	}
	
	// 거래처 추가 페이지
	@RequestMapping(value = "/accountAdd", method = RequestMethod.GET)
	public void accountAdd() throws Exception{
		logger.debug(" accountAdd() 호출 ");
		
	}
	
	@RequestMapping(value = "/accountAdd", method = RequestMethod.POST)
	public String accountAddPOST(AccountVO avo) throws Exception{
		logger.debug(" accountAddPOST(AccountVO avo) 호출 ");
		aService.accountAdd(avo);
		return "redirect:/account/accountMain";
	}
	
}