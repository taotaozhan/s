package org.lanqiao.util;

import java.security.interfaces.DSAKey;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	//定义TrheadLocal类对象，用于存放Connection对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(); 
	//定义数据源
	private static DataSource dataSource = new ComboPooledDataSource("lanqiao");
	//获取c3p0数据源
	public static DataSource getDataSource(){
		return dataSource;
	}
	//从c3p0连接池中 获取Connection 链接对象
	public static Connection getConnection(){
		Connection conn  = threadLocal.get();
			try {
				if(conn == null){
				conn = dataSource.getConnection();
				}
				threadLocal.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return conn;
	}
  
	//开启事务
	public static void beginTransaction(){
		Connection connection = getConnection();
		try {
			//手动开启事务
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//提交事务
	public static void commitTranscation(){
		Connection connection = threadLocal.get();
		try {
			if(connection != null){
				//提交事务
				connection.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//回滚事务
	public static void rollBackTranscation(){
		Connection connection = threadLocal.get();
			try {
				if(connection != null){
					if(connection != null){
						//事务回滚						
						connection.rollback();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close() {
		  Connection conn = threadLocal.get();
			   try {
				   if ( conn != null){
				conn.close();
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				// 从集合中移除当前绑定的连接
				   threadLocal.remove();
				   conn = null;
			}
			   
		   
	}
}
