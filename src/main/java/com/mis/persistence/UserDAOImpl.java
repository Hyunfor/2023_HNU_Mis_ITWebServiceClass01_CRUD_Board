package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.DTO.LoginDTO;
import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mis.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + ".login", dto);
	}

	@Override
	public void create(UserVO vo) throws Exception {
		sqlSession.insert(namespace + ".create", vo);
		
	}

	@Override
	public UserVO read(String usid) throws Exception {
		return sqlSession.selectOne(namespace + ".read", usid);
	}

	@Override
	public void update(UserVO vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(String usid) throws Exception {
		sqlSession.delete(namespace + ".delete", usid);	
		
	}

	@Override
	public List<UserVO> listSearch(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);
	}

}
