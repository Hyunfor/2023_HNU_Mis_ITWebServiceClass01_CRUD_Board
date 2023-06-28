package com.mis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() { // 리턴타입 => 사용자 화면을 선택 => void => 맵핑주소와 동일한 jsp리턴
		// WEB-INF/views/doA.jsp 실행. 
		logger.info("doA() called.....");
		
	}
	
	@RequestMapping("doB")
	public String doB() {// 리턴타입 => 사용자 화면을 선택 => String => home.jsp 리턴
		// WEB-INF/views/home.jsp 리턴
		logger.info("doB() called.....");
		return "home";
		
	}

}
