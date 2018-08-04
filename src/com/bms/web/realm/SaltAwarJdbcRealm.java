package com.bms.web.realm;


import org.apache.shiro.realm.jdbc.JdbcRealm;

public class SaltAwarJdbcRealm extends JdbcRealm {

	private static final String CUSTOM_AUTHENTICATION_QUERY = "select password,passwordSalt from users where username = ?";

	public SaltAwarJdbcRealm() {
		super();

		setSaltStyle(SaltStyle.COLUMN);
		
//		AuthenticationToken token = null;
//		
//		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//		
//		String username = upToken.getUsername();
//		
//		char[] password = upToken.getPassword();
//		
//		UsernamePasswordToken uptoken = new UsernamePasswordToken(username, password);
//		
//		uptoken.setRememberMe(true);

		setAuthenticationQuery(CUSTOM_AUTHENTICATION_QUERY);
		
	}
	
	
	
}

