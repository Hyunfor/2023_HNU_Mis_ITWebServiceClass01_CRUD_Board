package com.mis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
					// 절대 변하지 않는 변수(보안)
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		
		// UserController에서 Model 객체에 담긴 UserVO 확인
		if(userVO != null) {
			
			// Session 객체에 UserVO 정보 담기
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
		
			// 로그인 전 보고 있었던 화면(url) 확인
			Object dest = session.getAttribute("dest");

			// 로그인 전 보고 있었던 화면(url)으로 이동
			response.sendRedirect(dest != null ? (String)dest : "/"); // 조건 ? true : false
			
		}
		
	}
	
	
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		// postHandle() 메서드 실행 전처리
		HttpSession session = request.getSession();
		
		// 중복 로그인 방지 ( 기존에 로그인 안된 계정에 대한 자원을 지워줌 )
		if(session.getAttribute(LOGIN) != null) {
			
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
			
		}
		
		
		return true;
	}

}
