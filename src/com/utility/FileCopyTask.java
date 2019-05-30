package com.utility;
 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.TimerTask;
 
/*
 * To run multiple files copy task every 2 minutes
 */

public class FileCopyTask {	
 
	Path tempFolder = Paths.get("/Users/pt/temp");
 
	Path securedFolder = Paths.get("/Users/pt/secured");
	
	public void copy() throws InterruptedException {
	
	while (true) 
	{ 
	    synchronized (this) 
	    { 	
		System.out.println("Copying Files every 2 minutes");
 
		File folder = new File(tempFolder.toString());
 
		File[] listOfFiles = folder.listFiles();
 
		try {
			if (listOfFiles.length > 0) {
 
				for (File file : listOfFiles){	
				
					File source = new File(tempFolder + "//" + file.getName());
 
					File destination = new File(securedFolder + "//" + file.getName());
 
					Files.copy(source.toPath(), destination.toPath(), 
							StandardCopyOption.REPLACE_EXISTING);
				}
				
				
				Thread.sleep(120000); 
			}
			
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	    }
	}
  
	}
}