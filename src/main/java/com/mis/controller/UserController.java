package com.mis.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mis.DTO.LoginDTO;
import com.mis.domain.UserVO;
import com.mis.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) throws Exception {
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, Model model) throws Exception {
		
		UserVO vo = service.login(dto);
		
		// 로그인 실패시
		if(vo == null) {
			return;
		}
		
		// 로그인 성공시
		model.addAttribute("userVO", vo);
		
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		Object userVO = session.getAttribute("login");
		
		// 로그인 되어 있을 경우에
		if(userVO != null) {
			session.removeAttribute("login");
			session.invalidate();
		}
		
		return "redirect:/";
		
	}

}
