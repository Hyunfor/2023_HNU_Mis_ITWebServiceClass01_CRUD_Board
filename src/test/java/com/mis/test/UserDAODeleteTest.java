package com.mis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.UserVO;
import com.mis.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class UserDAODeleteTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDAODeleteTest.class);

	@Inject
	private UserDAO dao;

	@Test
	public void testDelete() throws Exception {

		dao.delete("8");

		List<UserVO> list = dao.listSearch();

		for (UserVO vo : list) {
			logger.info("testDelete: " + vo);

		}

	}

}
