package com.mis.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.DTO.LoginDTO;
import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;
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

	@Override
	public void create(UserVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public ProductVO read(String usid) throws Exception {
		return dao.read(usid);
	}

	@Override
	public void update(UserVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void delete(String usid) throws Exception {
		dao.delete(usid);
		
	}

	@Override
	public List<UserVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	

}
