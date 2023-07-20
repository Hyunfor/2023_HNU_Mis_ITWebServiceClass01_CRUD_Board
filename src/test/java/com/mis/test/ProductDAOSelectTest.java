package com.mis.test;

import java.util.List;

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
public class ProductDAOSelectTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOSelectTest.class);
	
	@Inject
	private ProductDAO dao;
	
	@Test
	public void testListSearch() throws Exception{
		
		List<ProductVO> list = dao.list();
		
		for(ProductVO vo : list) {
			logger.info("testListSearch: " + vo);
			
		}
		
	}
	
	@Test
	public void testRead() throws Exception{
		
		logger.info("testRead : " + dao.read(1));
		
	}

}
