package com.JavaMan.service;

import java.io.IOException;

import com.JavaMan.pojo.PageInfo;

public interface LogService {
	/**
	 * 分页功能
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws IOException 
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
	
	PageInfo showLogByIO(String accIn,String accOut,int pageSize,int pageNumber) throws IOException;
}
