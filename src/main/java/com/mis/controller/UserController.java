package com.mis.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.DTO.LoginDTO;
import com.mis.domain.PageMaker;
import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) throws Exception {

	}

	// 로그인
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, Model model) throws Exception {

		UserVO vo = service.login(dto);

		// 로그인 실패시
		if (vo == null) {
			return;
		}

		// 로그인 성공시
		model.addAttribute("userVO", vo);

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		Object userVO = session.getAttribute("login");

		// 로그인 되어 있을 경우에
		if (userVO != null) {
			session.removeAttribute("login");
			session.invalidate();
		}

		return "redirect:/";

	}

	// 회원 관리 - 회원 정보 등록
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("register get ...");

	}

	// 회원 정보 등록 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo) throws Exception {

		logger.info("register post ...");

		service.create(vo);

		return "redirect:/user/list";

	}

	// memberRegister에서 회원 가입
	@RequestMapping(value = "/memberRegister", method = RequestMethod.GET)
	public String memberRegisterGET() throws Exception {

		logger.info("user_register get ...");
		
		return "user/user_register"; // user_register.jsp로 이동

	}

	// memberRegister에서 회원 가입
	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public String memberRegisterPOST(UserVO vo) throws Exception {

		logger.info("user_register post ...");

		 // 회원 가입 처리 로직 (vo를 이용하여 데이터 저장)
		service.create(vo);

		// 회원 목록 페이지로 리다이렉트
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		// 선택된 페이지의 게시글 정보 가져오기
		model.addAttribute("list", service.listSearch(cri));

		// 페이징 네비게이션 추가
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		// 페이징 정보 화면 전달
		model.addAttribute("pageMaker", pageMaker);

	}

	// 회원 상세보기
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("usid") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model,
			String usid) throws Exception {

		model.addAttribute(service.read(usid));

	}

	// 회원정보 수정
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPageGET(@RequestParam("usid") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model,
			String usid) throws Exception {

		model.addAttribute(service.read(usid));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(UserVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.update(vo);

		// 수정 후 페이징 및 검색 기능 유지
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/user/list";

	}

	// 회원 삭제
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("usid") int bno, RedirectAttributes rttr, String usid) throws Exception {

		service.delete(usid);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/user/list";
	}

}
