package kr.or.shi.board.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.shi.board.vo.BoardVO;

public interface BoardDAO {
//	public List selectAllBoardList() throws DataAccessException;
	
	public List<BoardVO> selectAllBoards(Map<String, Integer> pagingMap) throws DataAccessException;
	
	public int selectTotBoards() throws DataAccessException;

	public int insertBoard(BoardVO boardVO) throws DataAccessException;

	public int deleteBoard(String pro_noticeNum) throws DataAccessException;
	
	public List<BoardVO> searchBoard(BoardVO boardVO) throws DataAccessException;

	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;

	public List<BoardVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException;

	

	

}
