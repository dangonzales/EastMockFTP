package com.dangonzales.easymockftp;

import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.filesystem.FileSystem;

public class EasyFTPServerFactory {
	private static FakeFtpServer server = new FakeFtpServer();
	private static boolean fs_set = false;
	
	
	public static void start() throws Exception {
		if( !(server.getFileSystem() instanceof FileSystem) ) {
			throw new Exception("FileSystem not set");
		}
		if(EasyFTPServerFactory.server.getServerControlPort() == 21) {
			//TODO write a warning to the console about default port 21
		} 
		//start server
		EasyFTPServerFactory.server.start();
		if(EasyFTPServerFactory.server.getServerControlPort() == 0) {
			//TODO write the port that we're bound to
		}
		
	}
	
	//TODO close method
	//TODO delete all files
	//TODO user CRUD
	//TODO list files/dirs
	

	public static void setPort(int port) {
		EasyFTPServerFactory.server.setServerControlPort(port);
	}
	
	public void setFileSystem(EasyFTPFiles filesystem) {
		EasyFTPServerFactory.server.setFileSystem(filesystem.getFileSystem());
	}
	
	public void setUserAccounts(EasyFTPUser userAccounts) {
		EasyFTPServerFactory.server.setUserAccounts(userAccounts.getUserAccounts());
	}
	
	
	
}
