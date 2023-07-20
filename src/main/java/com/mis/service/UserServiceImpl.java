package com.mis.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.DTO.LoginDTO;
import com.mis.domain.UserVO;
import com.mis.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
	
	

}
