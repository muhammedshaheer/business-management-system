package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class LoginAction extends AbstractAction {
	
	private static String NEXT_PAGE = "error.jsp";
	
	enum Roles{
		
		admin("forward:adminHome.do"),
		
		sales("forward:salesHome.do");
		
		private String nextPage;
		
		Roles(String nextPage){
			
			this.nextPage = nextPage;
		}
		
		 public String nextPage() {
			 
		        return nextPage;
		    }
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("in login action");
		
		Subject currentUser = SecurityUtils.getSubject();
		
		for(Roles role : Roles.values()){
			
			if(currentUser.hasRole(role.toString())){
				
				NEXT_PAGE = role.nextPage();
			}
		}
		
		System.out.println("in login action.do : next page : " + NEXT_PAGE);
		
		return NEXT_PAGE;
	}

}
