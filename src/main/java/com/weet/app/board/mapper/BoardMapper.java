package com.weet.app.board.mapper;

import java.util.List;

import com.weet.app.board.domain.BoardVO;
import com.weet.app.exception.DAOException;

public interface BoardMapper {
	
	// 메인페이지의 '커뮤니티 인기글'
	public abstract List<BoardVO> selectBoardMain() throws DAOException;
}
