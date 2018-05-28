package org.lanqiao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBHelper {
/*    private  final static String   url="jdbc:oracle:thin:@localhost:1521:orcl";
    private final static String  username ="scott";
    private final static String password = "tiger";
    private final static String driver = "oracle.jdbc.driver.OracleDriver";
    private static Connection conn= null;
    
    //加载驱动
    static{
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //单列模式
    public static Connection getConnection() {
		try {
			if(conn==null){
				conn = DriverManager.getConnection(url, username, password);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;	
    }
    public static void main(String[] args) {
		conn = DBHelper.getConnection();
		if(conn == null){
			System.out.println("sfd");
		}else {
			System.out.println("sfdsafdas");
		}
	}
	*/
	//DBCP
	
	/*public static DataSource getDataSourceWithDBCP(){
		  BasicDataSource basicDataSource = new BasicDataSource() ;
		  //配置数据源中的数据库信息
		      basicDataSource
		.setDriverClassName("oracle.jdbc.OracleDriver");
		  basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		  basicDataSource.setUsername("scott");
		  basicDataSource.setPassword("tiger");
		  //设置数据源中的连接池参数
		  basicDataSource.setInitialSize(10);
		  basicDataSource.setMaxIdle(8);
		  basicDataSource.setMinIdle(2);
		  return basicDataSource ;
		  }
		    //测试DBCP数据源
		public static void main(String[] args) throws SQLException {
		    //通过getDataSourceWithDBCP()方法，获取DBCP数据源对象
		  DataSource ds = getDataSourceWithDBCP () ;
		         //通过DBCP数据源对象，获取Connection对象
		  Connection connection = ds.getConnection();
		  if(connection == null){
			  System.out.println("sfdas");
		  }else{
			  System.out.println("da");
		  }*/

	
	/*public  static DataSource getDataSourceWithDBCPByProperties () {
		  DataSource basicDataSource = null ; 
		  //创建一个配置文件对象props
		  Properties props = new Properties();
		  try{
		  //将配置文件中的信息读取到输入流中
		  InputStream input =new DBHelper().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties") ;
		  //将配置文件中的信息，从输入流加载到props中
		  props.load(input);
		  //根据props中的配置信息，创建数据源对象
		   basicDataSource = BasicDataSourceFactory.createDataSource(props) ;
		  }catch(Exception e){
		   e.printStackTrace();
		  }
		  return basicDataSource;
		 }
		 
		 public static void main(String[] args) throws SQLException {
		  DataSource ds1 = getDataSourceWithDBCPByProperties () ;
		  Connection connection1 = ds1.getConnection();
		  if(connection1 == null){
			  System.out.println("a");
		  }else {
			System.out.println("s");
		}
    }*/
	
	 /*//获取C3P0数据源对象
	 public static DataSource getDataSourceWithC3p0 (){
	  ComboPooledDataSource cpds = new ComboPooledDataSource();
	  try{
	   //设置数据库信息
	   cpds.setDriverClass("oracle.jdbc.OracleDriver");
	   cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	   cpds.setUser("scott");
	   cpds.setPassword("tiger");
	   //设置连接池信息
	   cpds.setInitialPoolSize(10);
	   cpds.setMaxPoolSize(20);
	   
	  }catch(Exception e){
	   e.printStackTrace();
	  }
	  return cpds;
	 }
	 
	 public static void main(String[] args) throws SQLException {
	  Connection connection = getDataSourceWithC3p0 ().getConnection();
	  if(connection == null){
		  System.out.println("adf");
	  }else {
		System.out.println("fdaafd");
	   }
	 }
	*/
	/*public static DataSource getDataSourceWithC3p0ByXML (){
		  ComboPooledDataSource cpds = new ComboPooledDataSource("lanqiao");
		  return cpds ; 
		 }
		  
		 public static void main(String[] args) throws SQLException {
		  Connection connection = getDataSourceWithC3p0ByXML ().getConnection();
		  if(connection == null ){
			  System.out.println("连接失败");
		  }else{
			  System.out.println("连接成功");
		  }
			  
		 }*/
	
	
	
}





