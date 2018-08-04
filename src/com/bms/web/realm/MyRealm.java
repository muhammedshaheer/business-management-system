package com.bms.web.realm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;

public class MyRealm extends JdbcRealm{
	
private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private static final String SQL_URL = "jdbc:mysql://127.0.0.1/businessmanagementsystem";

	private static final String USERNAME = "bms";

	private static final String PASSWORD = "bms@password";
	
	private DataSource dataSource = null;

	public MyRealm(){
		
		
	}

	
	public DataSource getDataSource() {
		
		if( null == dataSource){
			
			dataSource = createDataSource();
			
		}
		
		return dataSource;
	}

	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		
	}

	protected DataSource createDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName(DRIVER_CLASS);
		
		basicDataSource.setUrl(SQL_URL);
		
		basicDataSource.setUsername(USERNAME);
		
		basicDataSource.setPassword(PASSWORD);
		
		return basicDataSource;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
		
	}

	@SuppressWarnings("resource")
	@Override
	protected SaltedAuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("failure");
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String username = upToken.getUsername();
		
		String password = null;
		
		String salt = null;

		if (username == null) {

			throw new AccountException();

		}
		
		SaltedAuthenticationInfo info = null;
		
		Connection connection = getConnection();

		ResultSet resultSet = null;

		Statement statement = null;
		

		try {
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from users where username ='"+username+"'");

			boolean foundResult = false;

			while (resultSet.next()) {

				if (foundResult) {

					throw new AuthenticationException("More than one user row found for user ["+ username + "]. Usernames must be unique.");
				}

				password = resultSet.getString(2);
				
			
				salt = resultSet.getString(3);
				
				
				foundResult = true;
			}

				
			}catch(SQLException e) {
				
				
				
				e.printStackTrace();
				
			}finally {

				JdbcUtils.closeResultSet(resultSet);

				JdbcUtils.closeStatement(statement);
				
				JdbcUtils.closeConnection(connection);

		}


		if (password == null) {

			throw new UnknownAccountException("No account found for user ["+ username + "]");

		}

		 SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
		 
		 saInfo.setCredentialsSalt(ByteSource.Util.bytes(salt));	
		 
		
		 info = saInfo;

		return info;
	}


	private Connection getConnection() {
		
		try{
			
			return getDataSource().getConnection();
			
			
		}catch(Exception e){
			
			throw new RuntimeException("Connection Failed");
			
		}
	
	}

}
