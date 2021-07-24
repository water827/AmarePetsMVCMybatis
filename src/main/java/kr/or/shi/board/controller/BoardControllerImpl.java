package kr.or.shi.board.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import kr.or.shi.board.dao.BoardDAO;
import kr.or.shi.board.service.BoardService;
import kr.or.shi.board.service.BoardServiceImpl;
import kr.or.shi.board.vo.BoardVO;
import net.sf.json.JSONObject;

@Controller("boardController")
@EnableAspectJAutoProxy	
public class BoardControllerImpl extends MultiActionController implements BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardVO boardVO;
	
	@RequestMapping(value = "/main.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/board/listBoards.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String section_ = request.getParameter("section");
		String pageNum_ = request.getParameter("pageNum");
		
		int section = Integer.parseInt(((section_== null)? "1" : section_));
		int pageNum = Integer.parseInt(((pageNum_ == null)? "1" : pageNum_));
		
		Map<String, Integer> pagingMap = new HashMap<>();			/*section값과 pageNum값을 HashMap에 저장*/
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		
		Map boardMap = boardService.listBoards(pagingMap);
		boardMap.put("section", section);
		boardMap.put("pageNum", pageNum);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardMap", boardMap);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/board/keywordSearch.do", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public String keywordSearch(@RequestParam("keyword") String keyword, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(keyword == null || keyword.equals(""))
			return null;
		
		keyword = keyword.toUpperCase();
		
		List<String> keywordList = boardService.keywordSearch(keyword);
		
		//최종 완성될  JSONObject 선언
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword", keywordList);
		
		String jsonInfo = jsonObject.toString();
		
		return jsonInfo;
	}

	@Override
	@RequestMapping(value = "/board/searchBoards.do", method = RequestMethod.GET)
	public ModelAndView searchBoards(@RequestParam("searchWord") String searchWord, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		List<BoardVO> boardsList = boardService.searchBoards(searchWord);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardsList", boardsList);
		
		return mav;
	}
	
	@RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


	@RequestMapping(value = "/board/addBoard.do", method = RequestMethod.GET)
	public ModelAndView addBoard(@ModelAttribute("board") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		int result = boardService.addBoard(boardVO);
		

//		  if(boardVO.getPro_img() != null && boardVO.getPro_img().length() != 0) {
//		  //이미지 파일 위치 생성(임시) File srcFile = new
//		  File("C:\\workspace-sts\\webstore_image\\temp\\"+pro_img); //이미지 저장될 디렉토리 생성
//		  File destDir = new File(ARTICLE_IMAGE +"\\"+ pro_noticeNum);
//		  
//		  destDir.mkdirs(); FileUtils.moveFileToDirectory(srcFile, destDir, true); }
		 
		
		ModelAndView mav = new ModelAndView("redirect:/board/listBoards.do");
		
		return mav;
	}

	@RequestMapping(value = "/board/removeBoard.do", method = RequestMethod.GET)
	public ModelAndView removeBoard(@RequestParam("pro_noticeNum") String pro_noticeNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		boardService.removeBoard(pro_noticeNum);
		ModelAndView mav = new ModelAndView("redirect:/board/listBoards.do");
		
		return mav;
	}

	@Override
	public ModelAndView addBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView removeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}






}
