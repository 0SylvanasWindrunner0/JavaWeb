package com.JavaMan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.JavaMan.pojo.Log;

public interface LogMapper {
	/**
	 * 插入转账信息(log)
	 * @param log
	 * @return
	 */
	int insLog(Log log);
	
	/**
	 * 实现分页（起始页，页面大小）
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	List<Log> selByPage(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);
	
	/**
	 * 统计表中个数
	 * @return
	 */
	long selCount();

	/**
	 * 根据转出账户与装入账户查找记录
	 * @param accIn
	 * @param accOut
	 * @param pageSize 
	 * @param pageStart 
	 * @return
	 */
	List<Log> selLogByIO(@Param("accin")String accIn,@Param("accout")String accOut,@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);

	/**
	 * 查询符合条件个数
	 * @param accIn
	 * @param accOut
	 * @return
	 */
	long selCountByIO(@Param("accin")String accIn,@Param("accout")String accOut);
}
