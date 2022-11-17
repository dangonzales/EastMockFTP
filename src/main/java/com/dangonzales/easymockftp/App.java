package com.dangonzales.easymockftp;

import java.util.Scanner;

/**
 * An example of how to start/stop the server.
 *
 */
public class App 
{
	/**
	 *
	 * @param args cli args [NYI]
	 */
    public static void main( String[] args )
    {
    	//Define a port to connect to
    	EasyFTPServerFactory.setPort(60065);
    	
    	//Let's set up some dummy data for the file system
    	String[] dirs = {"/test1","/emptydir"};
    	String[][] files = {
    			{"/test1/file1","sample contents"},
    			{"/test1/file2","another text file"}
    	};
    	
    	EasyFTPFiles fs = new EasyFTPFiles();
    	fs.addDirectory(dirs);
    	fs.addFile(files);
    	
    	//Let's define the users that can connect to the FTP service
    	String[][] users_array = {
    			{"myuser","pass123"},
    			{"anotheruser","pass456"}
    	};
    	EasyFTPUser users = new EasyFTPUser();
    	users.addUser(users_array);
    	
    	//Set everything for the server
    	EasyFTPServerFactory.setUserAccounts(users);
    	EasyFTPServerFactory.setFileSystem(fs);
    	
    	//Server will run until we interrupt it with input
		try (Scanner scanner = new Scanner(System.in)) {
			EasyFTPServerFactory.start();
			System.out.println("Server started successfully");
			System.out.println("Press \"ENTER\" to terminate the server");
			scanner.nextLine();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			//let's clean up
			EasyFTPServerFactory.stop();
		}
    }
    
}
