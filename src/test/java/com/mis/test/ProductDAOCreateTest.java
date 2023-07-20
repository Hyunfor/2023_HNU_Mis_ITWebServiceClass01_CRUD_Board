package com.mis.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.ProductVO;
import com.mis.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class ProductDAOCreateTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOCreateTest.class);
	
	@Inject
	private ProductDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		
		ProductVO vo = new ProductVO();
		vo.setPname("새로운 상품");
		vo.setContent("상품 설명");
		vo.setPrice(2000);
		vo.setWriter("테스트 상품");
		
		logger.info("testCreate: " + vo);
		
		dao.create(vo);
		
	}

}
