package com.JavaMan.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.JavaMan.pojo.PageInfo;
import com.JavaMan.service.LogService;
import com.JavaMan.serviceImpl.LogServiceImpl;

@WebServlet("/showLogServlet")
public class ShowLogServlet extends HttpServlet{
	private LogService logService = new LogServiceImpl();
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		//初次访问时默认参数
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 10;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}
		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		}
		
		PageInfo pi = logService.showPage(pageSize, pageNumber);
		req.setAttribute("pageInfo", pi);
		req.getRequestDispatcher("/log/showLogPage.jsp").forward(req, resp);
	}
}
