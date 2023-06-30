package com.mis.service;

import java.util.List;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;

public interface BoardService {

	public void register(BoardVO vo) throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void moidfy(BoardVO vo) throws Exception;

	public void remove(int bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	// 게시글 페이징 처리
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	// 전체 게시글 수 카운트
	public int listCountCriteria(Criteria cri) throws Exception;

}
