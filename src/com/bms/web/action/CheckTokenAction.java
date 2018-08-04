package com.bms.web.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.bms.util.PasswordHash;

public class CheckTokenAction {
	
	private static final String GET_DATA_QUERY = "SELECT `tokenhash`,`timestamp`,`salt` FROM `reset_password_links` WHERE `username` = ?";
	
	private static final String DELETE_TOKEN_QUERY = "DELETE FROM `reset_password_links` WHERE `username` = ?";
	
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
	
	
	public Boolean checkToken(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		
		String token = (String) session.getAttribute("token");
		
		token = token.replace(" ", "+");
		
		ArrayList<String> list = getDataFromDB(request);
		
		String hashedTokenFromDB = list.get(0);
		
		String salt = list.get(1);
		
		String hashedToken = PasswordHash.getHashedpassword(token,salt);
		
		try{
		
			if(hashedToken.equals(hashedTokenFromDB)){
				
				return true;
			}		
			else{
				
				return false;
			}
		
		} catch(NullPointerException e){
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
				
			return null;
		//	request.getRequestDispatcher("error.jsp").forward(request, response);
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
	
	
	
	@SuppressWarnings("finally")
	private ArrayList<String> getDataFromDB(HttpServletRequest request){
		
		String token = null;
		
		ArrayList<String> list = new ArrayList<String>();
		
		try{
		
			//Class.forName("com.mysql.jdbc.Driver"); 
		  
			Connection con = connect();
			
			PreparedStatement preparedStatement = con.prepareStatement(GET_DATA_QUERY);
	  
			preparedStatement.setString(1, request.getParameter("username"));
			
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			
			token = rs.getString(1);
			
			Timestamp timestamp = rs.getTimestamp(2);
			
			String salt = rs.getString(3);
			
			list.add(token);
			
			list.add(salt);
			
			if(!(validate(timestamp))){
				
				return null;
			}
			
			else{
				
			}
				
			preparedStatement = con.prepareStatement(DELETE_TOKEN_QUERY);
			
			preparedStatement.setString(1, request.getParameter("username"));
		  
			preparedStatement.executeUpdate();
			
		    rs.close();
			
			preparedStatement.close();
	  
		}
		catch(Exception e){
	  
		  System.out.println(e); 
	  
		  throw new RuntimeException();
	  }
		finally{
			
			return list;
		}
	}
	
	
	
	private boolean validate(Timestamp timestamp) {
		
		Timestamp currentTimestamp = getTimestamp(); 
		
		if((currentTimestamp.getTime() - timestamp.getTime())> 86400000){
		
			return false;
		}
		else{
		
			return true;
		}
	}

	

	private Timestamp getTimestamp() {

		return new Timestamp(System.currentTimeMillis());
	}
	
}
