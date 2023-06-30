package com.mis.persistence;

import java.util.List;
import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	// 전체 게시글 수 카운트
	public int listCountCriteria(Criteria cri) throws Exception;

}