package com.bms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.User;
import com.bms.domain.UserRoles;
import com.bms.util.PasswordHash;

public class UserServiceImpl implements UserService {

	private HibernateTemplate template;
	
	private static final String UPDATE_QUERY = "UPDATE `users` SET `password`= ? ,`passwordSalt`= ?  WHERE `username` = ?";
	
	private static final String URL = "jdbc:mysql://127.0.0.1/businessmanagementsystem?autoReconnect=true&useSSL=false";

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
	
	public HibernateTemplate getTemplate() {
		
		return template;
		
	}
	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
		
	}
	
	@Override
	public User getUser() {
		
		User user = null;
		
		return user;
	}

	@Override
	public void addUser(User user, UserRoles userRoles) {
		
		template.save(user);
		
		template.save(userRoles);	
		
	}
	

	@Override
	public void updatePassword(String username, String password) {
		
		ArrayList<String> list = PasswordHash.getHashedpassword(password); 
		
		try{
		
			
		  
			Connection con = connect();
	
			PreparedStatement preparedStatement = getPreparedStatement(con, username, list);
			  
			preparedStatement.close();
  
		} catch(Exception e){
	  
		  System.out.println(e); 
	  
		  throw new RuntimeException();
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



	private BasicDataSource createMyDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName(DRIVER_CLASSNAME);

		basicDataSource.setUsername(USER_NAME);

		basicDataSource.setPassword(PASSWORD);

		basicDataSource.setUrl(URL);

		return basicDataSource;

	}
	
	
	private PreparedStatement getPreparedStatement(Connection con, String username, ArrayList<String> list) throws SQLException{
		
		String hashedPassword = list.get(0);
		
		String salt = list.get(1);
		
		PreparedStatement preparedStatement = con.prepareStatement(UPDATE_QUERY);
		  
		preparedStatement.setString(1, hashedPassword);
	
		preparedStatement.setString(2, salt);
	
		preparedStatement.setString(3, username);
		
		System.out.println("update query : " + preparedStatement);
	
		preparedStatement.executeUpdate();

		return preparedStatement;
	}

}
