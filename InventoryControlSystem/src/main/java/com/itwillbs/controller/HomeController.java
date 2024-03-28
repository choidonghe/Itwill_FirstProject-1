package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.AuthVO;
import com.itwillbs.domain.EmergencyOrderVO;
import com.itwillbs.domain.ErgOrderCriteria;
import com.itwillbs.domain.MemberVO;
import com.itwillbs.domain.NoticeCriteria;
import com.itwillbs.domain.NoticePageVO;
import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.ReleaseVO;
import com.itwillbs.domain.ErgOrderPageVO;
import com.itwillbs.service.MainService;
import com.itwillbs.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private MemberService mService;
	
	@Inject  
	private MainService mainService;   
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		logger.debug(" registerGET() 호출");
		
	}
	
	@RequestMapping(value = "/confirmid", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> idCheckPOST(String id) throws Exception{
		logger.debug(" idCheckPOST() 호출");
		logger.debug("조회된 아이디 : "+mService.idCheck(id));
		int result = 0;;
		if(id != "") {
			logger.debug("조회된 아이디 : "+mService.idCheck(id));	
			
			
		}
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK );
		
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session) throws Exception{
		logger.debug(" loginPOST() 호출");
		AuthVO authVO = mService.memberLogin(vo);
		logger.debug(" 로그인 id & auth : "+authVO);
		
		
		
		if(!authVO.getAuth().isEmpty()) { // 정상 로그인
			session.setAttribute("authVO", authVO);
			
			return "redirect:/main";
		}
		
		// 비밀번호 오류
		return "/login";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(MemberVO vo) throws Exception{
		logger.debug(" registerPOST() 호출");
		logger.debug(" memberVO : "+vo);
		
		mService.memberInsert(vo);
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/registerkakao", method = RequestMethod.GET)
	public String registerkakaoGET(@RequestParam("code") String code, HttpSession session)throws Exception{
		logger.debug("tokenGET() 호출");
		logger.debug(" code : "+code);
		
		MemberVO vo =  mService.kakaoInfo(code);
		logger.debug("!!!!!!!!!!!!!!"+vo);
		MemberVO cvo = mService.checkUser(vo);
		
		if(cvo == null) {
			
			mService.memberKakaoInsert(vo);
			
			logger.debug(" 카카오 회원가입 완료! ");
			cvo = mService.kakaoMemberGet(vo);
		}
			
		AuthVO authVO = new AuthVO();
		authVO.setId(cvo.getId());
		authVO.setAuth(cvo.getAuth());

		session.setAttribute("authVO", authVO);
		
		logger.debug(" main 페이지로 이동");
		return "redirect:/main";
	}
	
	@GetMapping(value = "/logout")
	public String logoutGET(HttpSession session) throws Exception{
		logger.debug("logoutGET() 실행");
		session.invalidate();
		
		return "redirect:/login";
	}
	
	
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET(ErgOrderCriteria oCri,NoticeCriteria nCri, Model model) throws Exception{
		logger.debug(" main() 실행");
		
		//model.addAttribute("memberVO", vo);
		
		List<String> sellList = mainService.sellTotalGet();
		List<String> dayList = mainService.dayListGet();
		List<String> releaseList = mainService.releaseListGet();
		List<String> storeList = mainService.storeListGet();
		
		// 긴급발주ListGET
		ErgOrderPageVO orderPageVO = new ErgOrderPageVO();
		orderPageVO.setCri(oCri);
		orderPageVO.setTotalCount(mainService.getOrderListCount()); // 총 개수 직접 계산
		
		List<EmergencyOrderVO> ergList = mainService.ergOrederGet(oCri);
		// 긴급발주 페이징정보
		model.addAttribute("oCri", oCri);
		model.addAttribute("orderPageVO", orderPageVO);
		
		// 공지사항ListGET
		NoticePageVO noticePageVO = new NoticePageVO();
		noticePageVO.setCri(nCri);
		noticePageVO.setTotalCount(mainService.getNoticeListCount());
		
		List<NoticeVO> noList = mainService.noListGet(nCri);
		
		// 공지사항 페이징 정보
		model.addAttribute("nCri", nCri);
		model.addAttribute("noticePageVO", noticePageVO);
		
		// 데이터 저장
		model.addAttribute("sellList", sellList);
		model.addAttribute("dayList", dayList);
		model.addAttribute("releaseList", releaseList);
		model.addAttribute("storeList", storeList);
		model.addAttribute("ergList", ergList);
		model.addAttribute("noList", noList);
		
		
		
		
		//페이지 이동
		
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public void mainPOST(@RequestParam("id")String id ,@RequestParam("search") String search, ErgOrderCriteria oCri,NoticeCriteria nCri, Model model) throws Exception {
		logger.debug(" mainPOST() 호출");
		model.addAttribute("id", id);
		
		List<String> sellList = mainService.sellTotalGet();
		List<String> dayList = mainService.dayListGet();
		List<String> releaseList = mainService.releaseListGet();
		List<String> storeList = mainService.storeListGet();
		
		// 긴급발주ListGET
		ErgOrderPageVO orderPageVO = new ErgOrderPageVO();
		orderPageVO.setCri(oCri);
		orderPageVO.setTotalCount(mainService.getOrderListCount()); // 총 개수 직접 계산
		
		List<EmergencyOrderVO> ergList = mainService.ergOrederGet(oCri);
		
		// 긴급발주 페이징정보
		model.addAttribute("oCri", oCri);
		model.addAttribute("orderPageVO", orderPageVO);
		
		// 공지사항ListGET
		NoticePageVO noticePageVO = new NoticePageVO();
		noticePageVO.setCri(nCri);
		noticePageVO.setTotalCount(mainService.searchNoCount());
		
		List<NoticeVO> noList = mainService.searchNoListGet(nCri, search);
		
		// 공지사항 페이징 정보
		model.addAttribute("nCri", nCri);
		model.addAttribute("noticePageVO", noticePageVO);
		
		// 데이터 저장
		model.addAttribute("sellList", sellList);
		model.addAttribute("dayList", dayList);
		model.addAttribute("releaseList", releaseList);
		model.addAttribute("storeList", storeList);
		model.addAttribute("ergList", ergList);
		model.addAttribute("noList", noList);		
		
		
		
	}
	
	@RequestMapping(value = "/notice",method = RequestMethod.GET)
	public void noticeGET()throws Exception{
		logger.debug(" noticeGET() 호출");
		
		
	}
	
	@RequestMapping(value = "/notice",method = RequestMethod.POST)
	public String noticePOST(NoticeVO vo)throws Exception{
		logger.debug(" noticePOST() 호출 ");
		
		mainService.noticeWrite(vo);
		
		return "redirect:/main";
	}
	
	@GetMapping(value = "/noticeContent")
	public void NoticeContentGET(@RequestParam("bno") String bno, Model model ) throws Exception{
		logger.debug(" NoticeContentGET() 호출 ");
		
		model.addAttribute("content", mainService.noticeGet(bno));
		
	}
	
	@RequestMapping(value = "/dayStoreRelease", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> dayStoreReleasePOST(String startStr) throws Exception{
		logger.debug(" dayStoreReleasePOST() 호출");
		logger.debug("클릭한 날짜 : "+startStr);
		
//		List<ProductVO> productList = mainService.productDayGet(startStr);
//		logger.debug("!@@@@@@@@@"+productList);
//		
//		List<ReleaseVO> releaseList = mainService.releaseDayGet(startStr);
//		logger.debug(" !@@@@@@@@@@"+releaseList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("productList", mainService.productDayGet(startStr));
		map.put("releaseList", mainService.releaseDayGet(startStr));
		logger.debug("@@@@@@@"+map);
		
		return new ResponseEntity<>(map, HttpStatus.OK );
	}
	
		@GetMapping(value = "/adminPage")
		public void adminPageGET(Model model) throws Exception{
			logger.debug(" adminPageGET() 호출");
			
			List<MemberVO> mList = mService.memberListGet();
			model.addAttribute("mList", mList);
		}
	
		@PostMapping(value = "/adminPage")
		public String adminPagePOST(MemberVO vo)throws Exception{
			logger.debug(" adminPagePOST(MemberVO vo) 호출 ");

			mService.updateMember(vo);
			logger.debug(" 회원정보 수정 완료!");

			return "redirect:/adminPage";
		}
	
	
	
	
	
} // controller