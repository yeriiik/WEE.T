package com.weet.app.classes.service;

import java.util.List;

import com.weet.app.classes.domain.ClassVO;
import com.weet.app.classes.domain.Criteria;
import com.weet.app.exception.ServiceException;

public interface ClassService {
	
	// 메인페이지: 추천 클래스
	public abstract List<ClassVO> getListRecommend() throws ServiceException;
	public abstract List<ClassVO> getListRecommendAll() throws ServiceException;	// +더보기
	
	// 메인페이지: 마감임박 클래스
	public abstract List<ClassVO> getListEnd() throws ServiceException;
	public abstract List<ClassVO> getListEndAll() throws ServiceException;			// +더보기
	
	// 메인페이지: 신규 클래스
	public abstract List<ClassVO> getListNew() throws ServiceException;
	public abstract List<ClassVO> getListNewAll() throws ServiceException;			// +더보기
	
	// 클래스 검색 페이지: 모든 클래스
	public abstract List<ClassVO> getListAll() throws ServiceException;
	
	// 페이징 처리 된 전체 클래스 목록
	public List<ClassVO> getClassPaging(Criteria cri) throws ServiceException;
	
	public abstract int getTotal(Criteria cri);
} // end interface
