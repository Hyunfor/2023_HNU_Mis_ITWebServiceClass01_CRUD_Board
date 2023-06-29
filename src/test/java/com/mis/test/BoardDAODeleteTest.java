package com.mis.test;

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
public class BoardDAODeleteTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAODeleteTest.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testDelete() throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setBno(4);
		logger.info("testDelete: " + vo);
		
		dao.delete(vo);

	}
	
}
