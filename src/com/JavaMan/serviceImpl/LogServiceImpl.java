package com.JavaMan.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.JavaMan.mapper.LogMapper;
import com.JavaMan.pojo.Log;
import com.JavaMan.pojo.PageInfo;
import com.JavaMan.service.LogService;
import com.JavaMan.util.MyBatisUtil;

public class LogServiceImpl implements LogService{
	
	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		
		SqlSession session = MyBatisUtil.getSession();
		//mapper接口代理
		LogMapper logMapper = session.getMapper(LogMapper.class);
		
		
		PageInfo pi = new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		
		pi.setList(logMapper.selByPage(pageSize*(pageNumber-1), pageSize));
		
		//总条数
		long count = logMapper.selCount();
		pi.setPageTotal((long)Math.ceil(count/pageSize));
		
		return pi;
	}

	@Override
	public PageInfo showLogByIO(String accIn, String accOut,int pageSize,int pageNumber) throws IOException {
		
		SqlSession session = MyBatisUtil.getSession();
		//mapper接口代理
		LogMapper logMapper = session.getMapper(LogMapper.class);
		
		PageInfo pi = new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);

		pi.setList(logMapper.selLogByIO(accIn,accOut,pageSize*(pageNumber-1), pageSize));
		
		//总条数
		long count = logMapper.selCountByIO(accIn, accOut);
		pi.setPageTotal((long)Math.ceil(count/pageSize));
		
		
		return pi;
	}

	
}
