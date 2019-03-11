package com.JavaMan.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.JavaMan.mapper.AccountMapper;
import com.JavaMan.mapper.LogMapper;
import com.JavaMan.pojo.Account;
import com.JavaMan.pojo.Log;
import com.JavaMan.service.AccountService;
import com.JavaMan.util.MyBatisUtil;
import com.sun.istack.internal.logging.Logger;

public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		
		SqlSession session = MyBatisUtil.getSession();
		
		//创建mapper代理
		AccountMapper accountMapper = session.getMapper(AccountMapper.class);
		LogMapper logMapper = session.getMapper(LogMapper.class);
		
		Account accOutSelect = accountMapper.selByAccnoPwd(accOut.getAccNo(), accOut.getPassword());
		if(accOutSelect!=null){
			if(accOutSelect.getBalance()>=accOut.getBalance()){
				Account accInSelect = accountMapper.selByAccnoName(accIn.getAccNo(), accIn.getName());
				if(accInSelect!=null){
					accIn.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index = accountMapper.updBalanceByAccno(accOut.getBalance(),accOut.getAccNo());
					index += accountMapper.updBalanceByAccno(accIn.getBalance(), accIn.getAccNo());
					if(index == 2){
						//获取当前时间
						Date date = new Date();
					    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					    String dateString = formatter.format(date);
					    
						//日志表记录
						Log log = new Log();
						log.setAccIn(accIn.getAccNo());
						log.setAccOut(accOut.getAccNo());	
						log.setTime(dateString);
						log.setMoney(accIn.getBalance());
						
						//插入数据库
						logMapper.insLog(log);
						
						//日志文件记录
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut()+"给"+log.getAccIn()+"时间："+dateString+"转了"+log.getMoney());
									
						
						return SUCCESS;
					}else{
				
						return ERROR;
					}
				}else{
					//转账账号不存在
					return ACCOUNT_NAME_NOT_MATCH;
				}
			}else{
				//余额不足
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else{
			//账号和密码不匹配
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
	}

}
