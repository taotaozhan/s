package org.lanqiao.dao;

import java.sql.SQLException;

import org.lanqiao.eneity.Account;

public interface AccountDao {
    
	 //根据姓名，查询账户
	 public abstract Account queryAccountByName(String name)throws SQLException;
	    //修改账户（增加余额、减少余额）
	public abstract void updateAccount(Account account) throws SQLException;
}
