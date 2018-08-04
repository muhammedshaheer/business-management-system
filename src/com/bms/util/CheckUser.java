package com.bms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class CheckUser {
	
	private static final String GET_DATA_QUERY = "SELECT count(*) FROM `users` WHERE `username` LIKE ?";
	
	private static final String URL = "jdbc:mysql://127.0.0.1/businessmanagementsystem?useSSL=false";

	private static final String USER_NAME = "bms";

	private static final String PASSWORD = "bms@password";

	private static final String DRIVER_CLASSNAME = "com.mysql.jdbc.Driver";
	
	private DataSource dataSource = null;

	public DataSource getDataSource() {

		if (null == dataSource) {

			dataSource = createMyDataSource();
		}

		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	public boolean ifUserExist(ServletRequest request){
		
		if(getDataFromDB(request)){
			
			return true;
		}
		else{		
			
			return false;
		}
		
	}
	
		
	protected Connection connect() throws SQLException {

		Connection con = null;

		try {

			DataSource ds = getDataSource();
			
			con = ds.getConnection();

		} catch (Exception e) {

			System.out.println(e);
			
			e.printStackTrace();
		}

		return con;

	}


	// MysqlDataSource dataSource1 = new MysqlDataSource();

	private BasicDataSource createMyDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName(DRIVER_CLASSNAME);

		basicDataSource.setUsername(USER_NAME);

		basicDataSource.setPassword(PASSWORD);

		basicDataSource.setUrl(URL);

		return basicDataSource;

	}
	
	
	
	
	private boolean getDataFromDB(ServletRequest request){
	
		boolean flag = true;
		
		try{
		
			//Class.forName("com.mysql.jdbc.Driver"); 
		  
			Connection con = connect();
			
			PreparedStatement preparedStatement = con.prepareStatement(GET_DATA_QUERY);
	  
			preparedStatement.setString(1, request.getParameter("username"));
			
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			
			if(rs.getInt(1) == 0){
				
				flag = false;
			}
			
		} catch(Exception e){
			
			e.printStackTrace();
		}
		
			//if(rs == 0)
			return flag;		
	}


}
