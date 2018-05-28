package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.eneity.Account;
import org.lanqiao.util.DBUtil;

import com.mchange.v2.c3p0.impl.NewPooledConnection;

public class AccountImp implements AccountDao {

	@Override
	public Account queryAccountByName(String name) throws SQLException {
       QueryRunner queryRunner = new QueryRunner();
       Connection connection = DBUtil.getConnection();
       String sql = "select * from bancle where name = ?";
       Object[] parname = {name};
       Account account = null;
       account = queryRunner.query(connection, sql, new BeanHandler<Account>(Account.class),parname);
  
		return account;
	}

	public void updateAccount(Account account) throws SQLException {
		  QueryRunner runner = new QueryRunner(DBUtil.getDataSource());
		  Connection conn = DBUtil.getConnection() ;
		  String updateSql = "update bancle set bancle = ? where name = ?" ;
		  Object[] params = { account.getBancle(), account.getName() };
		  runner.update(conn, updateSql, params);
		 }
}
