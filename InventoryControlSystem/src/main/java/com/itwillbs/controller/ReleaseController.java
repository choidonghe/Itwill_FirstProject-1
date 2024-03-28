package com.itwillbs.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.itwillbs.persistence.ReleaseDAO;
import com.itwillbs.service.ReleaseService;

@Controller
@RequestMapping(value = "/release/*")
public class ReleaseController {

	@Inject
	private ReleaseService rService;

	private static final Logger logger = LoggerFactory.getLogger(ReleaseController.class);

	// http://localhost:8088/release/main

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void main(Criteria cri, Model model) throws Exception {
		logger.debug("main() 호출");

		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(rService.getReleaseListCount());

		List<ReleaseVO> mainList = rService.getListCri(cri);
		logger.debug("list.size :" + mainList.size());

		List<CodeVO> code = rService.codeList();

		model.addAttribute("mainList", mainList);
		model.addAttribute("cri", cri);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("code", code);

	}

	@RequestMapping(value = "information", method = RequestMethod.GET)
	public void information(String pno, Model model, Criteria cri) throws Exception {
		logger.debug("informatino() 호출");

		logger.debug("pno:" + pno);

		ReleaseVO infoList = rService.releaseInfoList(pno);
		logger.debug("infoList:" + infoList);

		model.addAttribute("infoList", infoList);

		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(rService.getReleaseListCount());

		model.addAttribute("cri", cri);

		model.addAttribute("pageVO", pageVO);

	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modify(String pno, Model model, Criteria cri) throws Exception {
		logger.debug("modify() 호출");

		logger.debug("pno:" + pno);

		ReleaseVO modifyList = rService.releaseInfoList(pno);
		List<CodeVO> code = rService.codeList();

		logger.debug("modifyList:" + modifyList);
		logger.debug("code:" + code);

		model.addAttribute("modifyList", modifyList);
		model.addAttribute("code", code);
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ReleaseVO rvo, Model model, String pno, Integer divcode, CodeVO code, Criteria cri,String id)
			throws Exception {
		logger.debug(" modifyPOST() 호출");
		
		logger.debug("rvo:" + rvo);
		logger.debug("divcode:" + divcode);
		logger.debug("code:" + code);
		logger.debug("id===>"+id);

		ReleaseVO inspectionList = rService.releaseModify(rvo);

		logger.debug("inspectionList:" + inspectionList);

		model.addAttribute("inspectionList", inspectionList);

		rService.releaseModify(rvo);

		return "redirect:/release/main?page=" + cri.getPage() + "&pageSize=" + cri.getPageSize();
	}

	@RequestMapping(value = "/information", method = RequestMethod.POST)
	public String removePOST(@RequestParam("pno") String pno, Criteria cri) throws Exception {
		logger.debug("String removePOST() 호출");
		logger.debug("pno:" + pno);

		rService.releaseDelete(pno);

		return "redirect:/release/main?page=" + cri.getPage() + "&pageSize=" + cri.getPageSize();

	}

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainInspectionPOST(String pno, int divcode, HttpSession session, Model model,ReleaseVO rvo) throws Exception {
		logger.debug("mainInspectionPOST() 호출");

		logger.debug("pno:" + pno);
		logger.debug("divcode:" + divcode);

		
		ReleaseVO inspectionList = rService.releaseMainInspection(rvo);

		logger.debug("inspectionList:" + inspectionList);

		model.addAttribute("inspectionList", inspectionList);

		if (divcode == 5) {
			return "redirect:/release/inspection";
		} else if (divcode == 6) {
			return "redirect:/release/release";
		}

		return "redirect:/release/main";

}
	
	@RequestMapping(value = "/inspection", method = RequestMethod.GET)
	public void inspection(HttpSession session, Model model, Criteria cri, Integer divcode) throws Exception {
		logger.debug("inspection() 호출");

		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(rService.cri5Count());

		logger.debug("pageVO=>" + pageVO);

		List<ReleaseVO> vo = rService.CriDiv5(cri);
		logger.debug("list.size :" + vo.size());

		List<CodeVO> code = rService.codeList();

		// 연결된 뷰 페이지에 정보 전달
		model.addAttribute("vo", vo);
		logger.debug("vo=>" + vo);

		model.addAttribute("cri", cri);
		logger.debug("cri=>" + cri);

		model.addAttribute("pageVO", pageVO);

		model.addAttribute("code", code);
	}

	@RequestMapping(value = "/inspection", method = RequestMethod.POST)
	public String InspectionPOST(String pno, int divcode, HttpSession session, Model model, ReleaseVO rvo,
			Integer order_count, Integer release_count, Integer error_count,String id) throws Exception {
		logger.debug("InspectionPOST() 호출");
		logger.debug("order_count:" + order_count);
		logger.debug("release_count:" + release_count);
		logger.debug("id=>>>"+id);

		logger.debug("pno:" + pno);
		logger.debug("divcode:" + divcode);

		ReleaseVO inspectionList = rService.releaseInspection(rvo);

		logger.debug("inspectionList:" + inspectionList);

		model.addAttribute("inspectionList", inspectionList);

		//ReleaseVO subtract = rService.releaseSubtract(pno, release_count);
		
		ReleaseVO subtract = rService.releaseSubtract(rvo);

		logger.debug("subtract:" + subtract);

		if (divcode == 6) {
			logger.debug("subtract -> " + subtract);

			model.addAttribute("subtract", subtract);

			return "redirect:/release/release";
		}

		return "redirect:/release/inspection";

	}

	@RequestMapping(value = "/release", method = RequestMethod.GET)
	public void release(HttpSession session, Model model, Criteria cri) throws Exception {
		logger.debug("release() 호출");

		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(rService.cri6Count());

		logger.debug("pageVO=>" + pageVO);

		List<ReleaseVO> vo = rService.CriDiv6(cri);
		logger.debug("list.size :" + vo.size());

		List<CodeVO> code = rService.codeList();

		model.addAttribute("vo", vo);
		logger.debug("vo=>" + vo);
		model.addAttribute("cri", cri);
		logger.debug("cri=>" + cri);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("code", code);
	}

	// http://localhost:8088/release/error

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public void error(HttpSession session, Model model, Criteria cri) throws Exception {
		logger.debug("error()");

		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(rService.cri6Count());

		logger.debug("pageVO=>" + pageVO);

		List<ReleaseVO> vo = rService.CriDiv6(cri);
		logger.debug("list.size :" + vo.size());

		List<CodeVO> code = rService.codeList();

		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("code", code);

	}

	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String errorPOST(String pno, Integer error_count, Model model, ReleaseVO rvo) throws Exception {
		logger.debug("errorPOST() 호출");

		logger.debug("error_count->" + error_count);

		rService.insertError(rvo);
		rService.updateError(rvo);
		rService.errorRelease(rvo);

		logger.debug("rvo=>" + rvo);

		return "redirect:/release/main";
	}

}
