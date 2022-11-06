package com.dangonzales.easymockftp;

import java.util.List;

import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.filesystem.FileSystem;

public class EasyFTPServerFactory {
	private static FakeFtpServer server = new FakeFtpServer();
	
	
	public static void start() throws Exception {
		if( !(server.getFileSystem() instanceof FileSystem) ) {
			throw new Exception("FileSystem not set");
		}
		//start server
		EasyFTPServerFactory.server.start();
		
	}
	
	public static void stop() {
		EasyFTPServerFactory.server.stop();
	}
	

	public static void setPort(int port) {
		EasyFTPServerFactory.server.setServerControlPort(port);
	}
	
	public static List<?> getFiles() {
		return EasyFTPServerFactory.getFiles("/");
	}
	
	public static List<?> getFiles(String path) {
		return EasyFTPServerFactory.server.getFileSystem().listNames(path);
	}
	
	public static void setFileSystem(EasyFTPFiles filesystem) {
		EasyFTPServerFactory.server.setFileSystem(filesystem.getFileSystem());
	}
	
	public static void setUserAccounts(EasyFTPUser userAccounts) {
		EasyFTPServerFactory.server.setUserAccounts(userAccounts.getUserAccounts());
	}

	
	
}