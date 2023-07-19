package com.mis.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.DTO.LoginDTO;
import com.mis.domain.UserVO;
import com.mis.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class UserLoginTest {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginTest.class);
	
	@Inject
	private UserDAO dao;
	
	@Test
	public void loginTest() {
		
		LoginDTO dto = new LoginDTO();
		dto.setUsid("user00");
		dto.setUpw("user00");
		
		try {
			UserVO vo = dao.login(dto);
			logger.info("loginTest()" + vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
