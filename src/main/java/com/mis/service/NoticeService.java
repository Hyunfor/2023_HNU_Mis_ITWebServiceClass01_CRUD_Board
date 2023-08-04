package com.mis.service;

import java.util.List;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

public interface NoticeService {

	public void register(NoticeVO vo) throws Exception; // 1. Notice 등록

	public NoticeVO read(int noticeNo) throws Exception; // 2. Notice 상세보기

	public void modify(NoticeVO vo) throws Exception; // 3. Notice 수정

	public void remove(int noticeNo) throws Exception; // 4. Notice 삭제
	
	// 5. Notice 검색 가능한 목록
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception;

	// 6. Notice 검색 가능한 목록 ---> 페이징 , 카운트
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 7. 관리자 :: 파일 목록
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception;

}
