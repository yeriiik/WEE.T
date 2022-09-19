package com.weet.app.classes.mapper;

import java.util.List;

import com.weet.app.classes.domain.ClassVO;
import com.weet.app.classes.domain.Criteria;
import com.weet.app.exception.DAOException;

public interface ClassMapper {

	// 추천 클래스
	public abstract List<ClassVO> selectClassRecommend() throws DAOException;
	public abstract List<ClassVO> selectClassRecommendAll() throws DAOException; // +더보기

	// 마감임박 클래스
	public abstract List<ClassVO> selectClassEnd() throws DAOException;
	public abstract List<ClassVO> selectClassEndAll() throws DAOException;		 // +더보기
	
	// 신규 클래스
	public abstract List<ClassVO> selectClassNew() throws DAOException;
	public abstract List<ClassVO> selectClassNewAll() throws DAOException;		 // +더보기
	
	// 모든 클래스(클래스 검색 페이지)
	public abstract List<ClassVO> selectAllClass() throws DAOException;
	
	// 페이징을 적용한 클래스 목록
	public abstract List<ClassVO> selectClassPaging(Criteria cri) throws DAOException;
	
	// 총 개수
	public int getTotal(Criteria cri);
} // end interface
