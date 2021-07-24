package kr.or.shi.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(ViewNameInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		try {
			String viewName = getViewName(request);
			request.setAttribute("viewName", viewName);;
			
			logger.info("viewName" + viewName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);

		// uri = contextPath + (view)fileName
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		System.out.println("uri : " + uri);

		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
			System.out.println("uri2 : " + uri);
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
			System.out.println("begin : " + begin);
		}

		int end;
		if (uri.indexOf(";") != -1) { // uri값에 ;문자를 찾았다면
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) { // uri값에 ?문자를 찾았다면
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);

		if (fileName.indexOf(".") != -1) { // view fileName(즉 .do)에서 확장자를 제외함
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}

		if (fileName.indexOf("/") != -1) { // view fileName에서 앞에 폴더가 있다면 제외함
			fileName = fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
		}

		return fileName;
	}
	
}
