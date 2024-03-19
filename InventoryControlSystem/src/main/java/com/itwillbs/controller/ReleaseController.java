package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.ReleaseService;

@Controller
@RequestMapping(value = "/release/*")
public class ReleaseController {
	
	@Inject
	private ReleaseService rService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ReleaseController.class);
	
	
	// http://localhost:8088/release/main
	
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public void ReleaseMain() {
		logger.debug(" ReleaseMain() : +ReleaseMain()호출 ");
		
	}
	

}
