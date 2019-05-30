package com.utility;

public class UtilityMain {
	
	public static void main (String[] args){
		
		final FileCopyTask fileCopyTask = new FileCopyTask();
		final FolderMonitoringTask folderMonitoringTask = new FolderMonitoringTask();
		
		Thread t1 = new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                try
                { 
                	fileCopyTask.copy(); 
                } 
                catch(InterruptedException e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
       
        Thread t2 = new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                try
                { 
                	folderMonitoringTask.monitor(); 
                } 
                catch(InterruptedException e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        // Start both threads 
        t1.start(); 
        
        try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        t2.start(); 
       
		
	}
 
}