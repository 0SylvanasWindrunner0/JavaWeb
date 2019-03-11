package com.JavaMan.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.JavaMan.util.MyBatisUtil;

/**
 * 过滤器在提前打开session
 * @author lk
 *
 */
@WebFilter("/*")
public class OpenSessionInView implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		SqlSession session = MyBatisUtil.getSession();
		
		try {
			filterChain.doFilter(servletRequest, servletResponse);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
