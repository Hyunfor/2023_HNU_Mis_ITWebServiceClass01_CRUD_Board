package com.mis.persistence;

import java.util.List;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

public interface NoticeDAO {

	// 1. Notice 등록 - 게시글에 소속된 첨부파일 등록을 위한 int(noticeNo) 리턴)
	public int adCreate(NoticeVO vo) throws Exception; 

	public NoticeVO read(int noticeNo) throws Exception; // 2. Notice 상세보기

	// 3. Notice 수정 - 어떤게 수정된건지 확인 불가능. 전체 게시글을 싹 지우고 새로 등록시킴.
	public void adUpdate(NoticeVO vo) throws Exception; 

	public void adDelete(int noticeNo) throws Exception; // 4. Notice 삭제
	
	// 5. Notice 검색 가능한 목록
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception;

	// 6. Notice 검색 가능한 목록 ---> 페이징 , 카운트
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 7. 파일 등록
	public void insertFile(NoticeFileVO fVo) throws Exception;

	// 8. 파일 삭제
	public void deleteFile(int noticeNo) throws Exception;

	// 9. 파일 목록
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception;
	
}
