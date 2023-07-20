package com.mis.persistence;

import java.util.List;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

public interface ProductDAO {
	
	public void create(ProductVO vo) throws Exception;
	
	public ProductVO read(int pno) throws Exception;
	
	public void update(ProductVO vo) throws Exception;
	
	public void delete(int pno) throws Exception;
	
	public List<ProductVO> listAll() throws Exception;
	
	// 페이징, 검색 기능을 제공하는 list 가져오는 기능
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;
	
	// 페이징, 검색 기능 게시물 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
