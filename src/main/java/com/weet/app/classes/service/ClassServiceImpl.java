package com.weet.app.classes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weet.app.classes.domain.ClassVO;
import com.weet.app.classes.domain.Criteria;
import com.weet.app.classes.mapper.ClassMapper;
import com.weet.app.exception.DAOException;
import com.weet.app.exception.ServiceException;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2

@Service("ClassService") // 인터페이스의 이름으로 등록
public class ClassServiceImpl implements ClassService {

	@Setter(onMethod_= {@Autowired})
	private ClassMapper mapper;
	
	
	// =========================== 메인페이지 ===========================
	// 추천 클래스
	@Override
	public List<ClassVO> getListRecommend() throws ServiceException {
		log.trace("getListRecommend() invoked.");
		
		try {
			return mapper.selectClassRecommend();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // getListRecommend

	
	// 마감임박 클래스
	@Override
	public List<ClassVO> getListEnd() throws ServiceException {
		log.trace("getListEnd() invoked.");
		
		try {
			return mapper.selectClassEnd();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // getListEnd


	@Override
	// 신규 클래스
	public List<ClassVO> getListNew() throws ServiceException {
		log.trace("getListNew() invoked.");
		
		try {
			return mapper.selectClassNew();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // getListNew

	
	// =========================== +더보기 ===========================
	@Override
	public List<ClassVO> getListRecommendAll() throws ServiceException {
		log.trace("getListRecommendAll() invoked.");
		
		try {
			return mapper.selectClassRecommendAll();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // getListRecommendAll


	@Override
	public List<ClassVO> getListEndAll() throws ServiceException {
		log.trace("getListEndAll() invoked.");
		
		try {
			return mapper.selectClassEndAll();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // getListEndAll


	@Override
	public List<ClassVO> getListNewAll() throws ServiceException {
		log.trace("getListNewAll() invoked.");
		
		try {
			return mapper.selectClassNewAll();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // getListNewAll
	
	
	
	// =================== 클래스 목록 페이지: 모든 클래스 ==================
	@Override
	public List<ClassVO> getListAll() throws ServiceException {
		try {
			return mapper.selectAllClass();
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	}

	// 페이징 처리 된 클래스 목록
	@Override
	public List<ClassVO> getClassPaging(Criteria cri) throws ServiceException {
		try {
			return mapper.selectClassPaging(cri);
		} catch(DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	}

	// 클래스 총 갯수
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}







} // end class
