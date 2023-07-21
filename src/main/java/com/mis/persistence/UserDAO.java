package com.mis.persistence;

import java.util.List;

import com.mis.DTO.LoginDTO;
import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;

	public void create(UserVO vo) throws Exception;

	public ProductVO read(String usid) throws Exception;

	public void update(UserVO vo) throws Exception;

	public void delete(String usid) throws Exception;

	// 페이징, 검색 기능을 제공하는 list 가져오는 기능
	public List<UserVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징, 검색 기능 게시물 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;

}
