package com.mis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.BoardVO;
import com.mis.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class BoardDAOSelectTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOSelectTest.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testListAll() throws Exception{
		
		List<BoardVO> list = dao.listAll();
		
		for(BoardVO vo : list) {
			logger.info("testListAll: " + vo);
			
		}
		
	}
	
	@Test
	public void testRead() throws Exception{
		
		logger.info("testRead : " + dao.read(1));
		
	}

}
