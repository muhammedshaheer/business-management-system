package com.bms.web.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.util.ByteSource;

import com.bms.util.PasswordHash;

public class SentResetLinkAction extends AbstractAction {
	
	private static final String HOST = "smtp.gmail.com"; 
	
	private static final String HOST_MAIL = "thanpodo2@gmail.com";
	
	private static final String PASSWORD="thanavidunnumpodo";
	
	private static final String DOMAIN = "@gmail.com"; 
	
	private String TO = "";
	
	private ByteSource token = null;

	private static final String NEXT_PAGE = "";
	
	private static final String BASE_URL = "http://localhost:8080/bms/resetPassword.jsp";
	
	//private static final String COUNT_USER_QUERY = "SELECT count(`username`) FROM `reset_password_links` WHERE `username` = ?";
	
	private static final String DELETE_USER_QUERY = "DELETE FROM `reset_password_links` WHERE `username` = ?";
	
	private String INSERT_QUERY = "INSERT INTO reset_password_links" + "(username, tokenhash, timestamp, salt) VALUES" + "(?,?,?,?)";

	private String username = "";
	
	private static final String URL = "jdbc:mysql://localhost:3306/businessmanagementsystem?useSSL=false";

	private static final String USER_NAME = "bms";

	private static final String DBPASSWORD = "bms@password";

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
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
			
		Properties props = setProperty();  
	     
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {  
    	
			protected PasswordAuthentication getPasswordAuthentication() {  
    
			return new PasswordAuthentication(HOST_MAIL,PASSWORD);  
			}  
		});  
  
		HttpSession newSession = request.getSession();
		
		username = (String) newSession.getAttribute("username");
		
		String mailID = username + DOMAIN;
		
		TO = mailID;
		
		try {  
    		
			MimeMessage message = setMessage(session);  
			
			Transport.send(message);  
  
		} catch (MessagingException e) {
    	 	
			e.printStackTrace();
			
			throw new RuntimeException();
		
		}
		
		storeInDB(request);
		
		return NEXT_PAGE;
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

		basicDataSource.setPassword(DBPASSWORD);

		basicDataSource.setUrl(URL);

		return basicDataSource;

	}
	
	
	private Properties setProperty(){
			
		Properties props = new Properties();
	 
		props.put("mail.smtp.host", HOST);  
	 
		props.put("mail.smtp.auth", "true");  
	 
		props.put("mail.smtp.starttls.enable", "true");
	 
		return props;
	}
 
 
	
	private MimeMessage setMessage(Session session) throws MessagingException{
	 	
		MimeMessage message = new MimeMessage(session);  
     
		message.setFrom(new InternetAddress(HOST_MAIL));  
		
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(TO));  
     	
		message.setSubject("Password reset link");  
     	
		message.setText(setTheText());   
	
		return message;
 }

	
	private String setTheText() {
				
		String initialContent = "One time password reset link \n ";
		
		token = getToken();
		
		String link = BASE_URL + "?token=" + token.toString() + "&username=" + username + "&useSSL=false";
		
		String text = initialContent + link;
		
		return text;
	}
	
	protected ByteSource getToken() {
		
		return new SecureRandomNumberGenerator().nextBytes();
		
	}
	
	private void storeInDB(HttpServletRequest request){
		
		try{
		
			Connection con = connect();
					
			PreparedStatement preparedStatement = con.prepareStatement(DELETE_USER_QUERY);
				  
			preparedStatement.setString(1, username);
			
			preparedStatement.executeUpdate();
		
			ArrayList<String> list = PasswordHash.getHashedpassword(token.toString());
			
			preparedStatement = con.prepareStatement(INSERT_QUERY);
	  
			preparedStatement.setString(1, username);
			
			preparedStatement.setString(2, list.get(0));
			
			preparedStatement.setTimestamp(3, getTimestamp());
			
			preparedStatement.setString(4, list.get(1));
			
			preparedStatement.executeUpdate();
		  
			preparedStatement.close();
	  
		}
		catch(Exception e){
	  
		  System.out.println(e); 
	  
		  throw new RuntimeException();
	  }
		
	}


	private Timestamp getTimestamp() {

		return new Timestamp(System.currentTimeMillis());
	}
	
}
