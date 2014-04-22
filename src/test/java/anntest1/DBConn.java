package anntest1;

import java.sql.Connection;
//import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	private static Connection conn = null;
	public static Connection getConn(){
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");//加載數據庫連接驅動
			String user="adminXMqZewB";//用戶名
			String pwd="kzyYLAMH9MZL";//密碼
			String url="jdbc:mysql://529094d45973cafe2e000008-kashu.rhcloud.com:52546/scaleapp?useUnicode=true&characterEncoding=utf8";//連接URL
			conn=DriverManager.getConnection(url, user, pwd);//獲取連接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		*/
		
		
		try{
			Context initialContext = new InitialContext();
			DataSource datasource = (DataSource)initialContext.lookup("java:comp/env/jdbc/MysqlDS");
			conn = datasource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}