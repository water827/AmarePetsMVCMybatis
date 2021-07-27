package kr.or.shi.board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.shi.board.dao.BoardDAO;
import kr.or.shi.board.vo.BoardVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public Map listBoards(Map<String, Integer> pagingMap) throws Exception {
		List<BoardVO> boardsList = boardDAO.selectAllBoards(pagingMap);		/* 전달된 pagingMap을 사용해 글 목록을 조회함*/
		int totBoards = boardDAO.selectTotBoards();								/* 테이블에 존재하는 글 수를 조회함 */
		
		Map articlesMap = new HashMap();
		articlesMap.put("boardsList", boardsList);
		articlesMap.put("totBoards", totBoards);
		
		return articlesMap;
	}
	
	@Override
	public List<String> keywordSearch(String keyword) throws Exception {
		
		List<String> list = boardDAO.selectKeywordSearch(keyword);
		
		return list;
	}


	@Override
	public List<BoardVO> searchBoards(String searchWord) throws Exception {
		List<BoardVO> boardsList = boardDAO.selectBoardsBySearchWord(searchWord);
		
		return boardsList;
	}

	//다중 이미지 추가 
	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int pro_boardNum = boardDAO.insertNewArticle(articleMap);
		articleMap.put("pro_boardNum", pro_boardNum);
		boardDAO.insertNewImage(articleMap);
		return pro_boardNum;
	}

	@Override
	public int removeBoard(String pro_noticeNum) throws Exception {
		return boardDAO.deleteBoard(pro_noticeNum);
	}

	@Override
	public List searchBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}
