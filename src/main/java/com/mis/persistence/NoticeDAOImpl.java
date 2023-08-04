package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mis.mapper.NoticeMapper";

	@Override
	public int adCreate(NoticeVO vo) throws Exception {
		// vo에 담아서 getNoticeNo 리턴
		session.insert(namespace + ".adCreate", vo);
		return vo.getNoticeNo();
	}

	@Override
	public NoticeVO read(int noticeNo) throws Exception {
		return session.selectOne(namespace + ".read", noticeNo);
	}

	@Override
	public void adUpdate(NoticeVO vo) throws Exception {
		session.update(namespace + ".adUpdate", vo);
		
	}

	@Override
	public void adDelete(int noticeNo) throws Exception {
		session.delete(namespace + ".adDelete", noticeNo);
		
	}

	@Override
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void insertFile(NoticeFileVO fVo) throws Exception {
		session.insert(namespace + ".insertFile", fVo);
		
	}

	@Override
	public void deleteFile(int noticeFileNo) throws Exception {
		session.delete(namespace + ".deleteFile", noticeFileNo);
		
	}

	@Override
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception {
		return session.selectList(namespace + ".fileList", noticeNo);
	}
	
	

}
