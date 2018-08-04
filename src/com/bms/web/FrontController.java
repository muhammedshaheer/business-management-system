package com.bms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bms.util.FileDownload;
import com.bms.web.action.Action;


public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MSG_ATTRIBUTE = "ERROR_MSG";
	
	private static final String ERROR_PAGE = "error.jsp";

	private ClassPathXmlApplicationContext context;

	
	public FrontController() {
		
		super();
	
	}

	
	public void init() throws ServletException {
		
		   super.init();
		
		   context = new ClassPathXmlApplicationContext("beans.xml");
		   
		  FileDownload.setMyServletContext(getServletContext());
		
	   }
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String actionClass = getActionClassName(request);
		
			Action action = (Action) context.getBean(actionClass);
			
			System.out.println("in frontcontroller : After execution");
		
			String nextPage = action.execute(request, response);
		
			System.out.println("in frontcontroller : next page : " + nextPage);
			
			showNextPage(request, response, nextPage);
			
			

		} catch (Exception e) {

			showErrorPage(request, response, e.getMessage());
		}

	}

	protected void showNextPage(HttpServletRequest request,HttpServletResponse response, String nextPage) {

		String uri[] = nextPage.split(":");
		
		

		String redirect = uri[0];

		String nextAction = uri[1];
		
		if ("redirect".equals(redirect)) {
			
			try {

				response.sendRedirect(nextAction);

			} catch (IOException e) {

				throw new RuntimeException("Invalid Action");

			}

		} else if ("forward".equals(redirect)) {

			try {
				
				if( !nextAction.equals("#") ){

					request.getRequestDispatcher(nextAction).forward(request,response);

				} else{
					
					
				}
			} catch (Exception e) {

				throw new RuntimeException("Invalid next page");
			}
		}

	}

	protected void showErrorPage(HttpServletRequest request,HttpServletResponse response, String errorMessage) {

		try {

			request.setAttribute(ERROR_MSG_ATTRIBUTE, errorMessage);

			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);

		} catch (Exception e) {

			throw new RuntimeException("Invalid next page");
		}

	}

	protected String getActionClassName(HttpServletRequest request) {

		String uri = request.getRequestURI();

		String[] domains = uri.split("/");

		String[] temp = domains[2].split(".do");

		String actionClass = temp[0];

		return actionClass;

	}

}
