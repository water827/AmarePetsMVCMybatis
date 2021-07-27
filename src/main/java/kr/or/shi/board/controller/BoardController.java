package kr.or.shi.board.controller;  

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
	
	public ModelAndView removeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public @ResponseBody String keywordSearch(@RequestParam("keyword") String keyword, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView searchBoards(@RequestParam("searchWord") String searchWord, 
				HttpServletRequest request, HttpServletResponse response) throws Exception;
}
