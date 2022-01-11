package com.TalentRecruit.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 

{
  
	Properties pro;
	  
	public ReadConfig()
	  
	  {
	  
		File src=new File ("./Configuration/config.properties");
	  
	  	  
	      try 
		  
	      {
			FileInputStream fis=new FileInputStream (src);
			pro=new Properties();
			
			try 
			
			{
				pro.load(fis);
				
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   } 
		  
		  
		  catch (FileNotFoundException e) 
		  
	      {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	      
	   
	      
	    }
	  
	public String getApplicationURL()
	  
	   {
	  	String url=pro.getProperty("baseURL");
	  	return url;
	   }
	  
	public String getUserEmail ()
	 
	  {  
		String usremail=pro.getProperty("email");
		return usremail;
		 
	  }
	 
	public String getUserPassword ()
	 
	 {  
		String passwd=pro.getProperty("password");
		return passwd;
		 
	 }

	public String getChromepath()
	
	 {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String getIEpath()
	
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
		
	}
	
	public String getFirefoxpath()
	
	{
	    String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	
    public String getedgepath()
	
	{
	    String edgepath=pro.getProperty("edgepath");
		return edgepath;
		
	}
	
}
