package com.bms.util;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

public class FileUpload {

	 public static String doUpload(FileItem item, String type, int maxID) {
		 
		 	String root = (FileUpload.class.getResource("FileUpload.class")).toString();
		 	
		 	String[] rootPathList = root.split("/.metadata");
		 	
		 	root = rootPathList[0];
		 	
		 	rootPathList = root.split("file:/");
		 	
		 	root = rootPathList[1];
		 	
		 	root = root.replaceAll("%20", " ");
		 	
		 	root = root.replace('/', '\\');
		 	
		 	String UPLOAD_BASE_LOCATION = root + "\\bms\\files\\";
			
			String UPLOAD_LOCATION = UPLOAD_BASE_LOCATION;
			
			String linkToFile = null;
			
			if (type.equals("prospect")){
				
				UPLOAD_LOCATION += "prospect";
				
			} else if (type.equals("proposal")) {
				
				UPLOAD_LOCATION += "proposal";
				
			} else if (type.equals("agreement")) {
				
				UPLOAD_LOCATION += "agreement";
				
			}
			
		
					try{String name = new File(item.getName()).getName();
					
					String[] nameList = name.split("\\.");
					
					maxID += 1;
					
					name = String.valueOf(maxID)+ "." + nameList[1];
							
					linkToFile = UPLOAD_LOCATION + File.separator + name;

					item.write(new File(linkToFile));

					
				} catch (Exception e) {
					
					e.printStackTrace();
				
				}
					
			linkToFile = linkToFile.replace(File.separatorChar,'/');

			return linkToFile;
			
	}
	
}
