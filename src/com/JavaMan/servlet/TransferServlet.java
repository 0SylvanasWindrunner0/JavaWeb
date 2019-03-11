package com.JavaMan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaMan.pojo.Account;
import com.JavaMan.service.AccountService;
import com.JavaMan.serviceImpl.AccountServiceImpl;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{
	private AccountService accService = new AccountServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accOutAccNo"));
		accOut.setPassword(req.getParameter("accOutPassword"));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		int index = accService.transfer(accIn, accOut);
		if(index == AccountService.SUCCESS){
			resp.sendRedirect("/Bank/showLogServlet");
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/Bank/error/error.jsp");
		}
	}
}
