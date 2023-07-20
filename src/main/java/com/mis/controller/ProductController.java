package com.mis.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.ProductVO;
import com.mis.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private ProductService service;

	// 상품 등록
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("register get ...");

	}

	// 상품등록 정보 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ProductVO vo) throws Exception {

		logger.info("register post ...");

		// 게시글 등록
		service.register(vo);

		return "redirect:/product/list";

	}

	// 상품 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {

		logger.info("list get ...");

		model.addAttribute("list", service.list());

	}

	// 상세보기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {

		logger.info("read get ...");

		model.addAttribute(service.read(bno));

	}

	// 삭제하기 - > POST로 구현 - > 삭제 후 redirect처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		logger.info("remove get ...");

		service.remove(bno);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/product/list";

	}

}