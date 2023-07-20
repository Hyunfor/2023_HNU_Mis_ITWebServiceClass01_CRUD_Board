package com.mis.service;

import java.util.List;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.SearchCriteria;

public interface BoardService {

	public void register(BoardVO vo) throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void modify(BoardVO vo) throws Exception;

	public void remove(int bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	// 게시글 페이징 처리
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	// 게시글 수 카운트
	public int listCountCriteria(Criteria cri) throws Exception;
	
	// 검색 + 페이징 기능 추가
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

}
