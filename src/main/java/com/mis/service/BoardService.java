package com.mis.service;

import java.util.List;

import com.mis.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO vo) throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void moidfy(BoardVO vo) throws Exception;

	public void remove(int bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;

}
