package kr.or.shi.board.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.shi.board.vo.BoardVO;

public interface BoardService {
	public Map listBoards(Map<String, Integer> pagingMap) throws Exception;

	public int addBoard(BoardVO boardVO) throws DataAccessException;

	public int removeBoard(String pro_noticeNum) throws DataAccessException;
	
	public List searchBoard(BoardVO boardVO) throws DataAccessException;

	public List<String> keywordSearch(String keyword) throws Exception;

	public List<BoardVO> searchBoards(String searchWord) throws Exception;

}
