package com.bms.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.util.FileDownload;

public class DownloadFileAction extends AbstractAction {
	
	private static final String NEXT_PAGE = "forward:#";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String url = request.getParameter("url");
		
		if(null == url){
			
			url =(String)request.getAttribute("url");
			
		} else{
			
			
			
		}
		
		try {
		
			FileDownload.doDownload(url, request, response);
			
		} catch (IOException e) {
			
			throw new RuntimeException(e.getMessage());
		
		}
	
		return NEXT_PAGE;
	}

}
