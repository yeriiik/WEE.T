package com.weet.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weet.app.board.domain.BoardVO;
import com.weet.app.board.mapper.BoardMapper;
import com.weet.app.exception.ServiceException;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2

@Service()
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_={@Autowired})
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getBoardMain() throws ServiceException {
		log.trace("getBoardMain() invoked");
		
		try {
			return this.mapper.selectBoardMain();
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getBoardMain

} // end class
