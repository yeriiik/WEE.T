package com.weet.app.board.service;

import java.util.List;

import com.weet.app.board.domain.BoardVO;
import com.weet.app.exception.ServiceException;

public interface BoardService {

	// 메인페이지의 '커뮤니티 인기글'
	public abstract List<BoardVO> getBoardMain() throws ServiceException;
	
} // end service
