package com.bms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownload {

	private static ServletContext myServletContext;

	public static void doDownload(String sourceUrl, HttpServletRequest request,HttpServletResponse response) throws IOException {

		
		FileInputStream inStream=null;
		
		OutputStream outStream=null;
		try {
			File downloadFile = new File(sourceUrl);
			
			inStream = new FileInputStream(downloadFile);

			myServletContext.getRealPath("");
			
			ServletContext context = myServletContext;

			String mimeType = context.getMimeType(sourceUrl);
			if (mimeType == null) {

				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			
			String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
			
			response.setHeader(headerKey, headerValue);

			outStream = response.getOutputStream();

			byte[] buffer = new byte[4096];
			
			int bytesRead = -1;

			while ((bytesRead = inStream.read(buffer)) != -1) {
				
				outStream.write(buffer, 0, bytesRead);
				
			}

		} catch (Exception e) {
			
			throw new RuntimeException(e.getMessage());
			
		}
	finally{
		
		inStream.close();
		
		outStream.close();
		
	}
		

	}

	public static ServletContext getMyServletContext() {
		
		return myServletContext;
		
	}

	public static void setMyServletContext(ServletContext myServletContext) {
		
		FileDownload.myServletContext = myServletContext;
		
	}

}
