package com.bms.util;

import java.util.ArrayList;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;

public class PasswordHash {
	
	//private static final String GET_DATA_QUERY = "SELECT `password`,`passwordSalt` FROM `users` WHERE `username` = ?";

	public static ArrayList<String> getHashedpassword(String password) {
		
		ByteSource salt = getSalt();
		
		int hashIterations = 2048;
		
		String hashedPassword = new Sha512Hash(password, salt.toString(), hashIterations).toBase64();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(hashedPassword);
		
		list.add(salt.toString());
		
		return list;
	}
	
	
	public static String getHashedpassword(String password, String salt) {
		
		int hashIterations = 2048;
		
		String hashedPassword = new Sha512Hash(password, salt, hashIterations).toBase64();
		
		return hashedPassword;
	}
	
	protected static ByteSource getSalt() {
		
		return new SecureRandomNumberGenerator().nextBytes();
		
	}
	/*
	@SuppressWarnings("finally")
	private static ArrayList<String> getDataFromDB(){
		
		String token = null;
		
		ArrayList<String> list = new ArrayList<String>();
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver"); 
		  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/businessmanagementsystem","bms","bms@password");
	  
			PreparedStatement preparedStatement = con.prepareStatement(GET_DATA_QUERY);
			
			preparedStatement.setString(1, "nihon753");
			
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			
			token = rs.getString(1);
			
			System.out.println("token : " + token);
			
			String salt = rs.getString(2);
			
			System.out.println("salt : " + salt);
			
			list.add(token);
			
			list.add(salt);
	
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
	
	
	public static void main(String[] args) {
		
		ArrayList<String> list = getDataFromDB();
		
		String hashedToken = list.get(0);
		
		String hp = getHashedpassword("haha", "orJiAMmqfNltOdqdR3NCYg==");
		
		System.out.println("entered hashed password : " + hp);
		
		if(hp.equals(hashedToken))
		System.out.println(" it is working");
		
	}
	*/
}
