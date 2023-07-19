package com.mis.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.BoardVO;
import com.mis.domain.PageMaker;
import com.mis.domain.SearchCriteria;
import com.mis.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	@Inject
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/sboard/list";

	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/sboard/list";
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
							// Param은 요청 후 사라짐
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno,
			@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
		
	}

}
