package com.mis.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.MemberVO;

@Repository
public class MemberDAOlmpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mis.mapper.MemberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + "insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne(namespace + ".readMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		
		// 자바에서 제공하는 컬렉션 사용(VO가 없거나, 잠깐 사용하기만 하면 되는 경우)
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace + ".readWithPW", paramMap);
	}
	
	

}
