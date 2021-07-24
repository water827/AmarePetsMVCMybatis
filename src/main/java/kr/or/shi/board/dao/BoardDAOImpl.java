package kr.or.shi.board.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.shi.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectAllBoards(Map<String, Integer> pagingMap) throws DataAccessException {
		List<BoardVO> boardsList = sqlSession.selectList("mapper.board.selectAllBoards", pagingMap);
		return boardsList;
	}

	@Override
	public int selectTotBoards() throws DataAccessException {
		int totBoards = sqlSession.selectOne("mapper.board.selectTotBoards");
		return totBoards;
	}
	
	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
		List<String> list = sqlSession.selectList("mapper.board.selectKeywordSearch", keyword);
		
		return list;
	}

	@Override
	public List<BoardVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException {
		ArrayList<BoardVO> list = (ArrayList)sqlSession.selectList("mapper.board.selectBoardsBySearchWord", searchWord);
		
		return list;
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.board.insertBoard", boardVO);
		return result;
	}

	@Override
	public int deleteBoard(String pro_noticeNum) throws DataAccessException {
		int result = sqlSession.delete("mapper.board.deleteBoard", pro_noticeNum);
		return result;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO boardVO) throws DataAccessException {
		List<BoardVO> boardsList = sqlSession.selectList("mapper.board.searchBoard", boardVO);
		return boardsList;
	}


	
	

}
