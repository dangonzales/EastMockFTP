package com.dangonzales.easymockftp;

import java.util.List;

import org.mockftpserver.fake.FakeFtpServer;

/**
 * Static class for abstracting away some steps required to start the FTP server
 */
public class EasyFTPServerFactory {
	private static final FakeFtpServer server = new FakeFtpServer();

	/**
	 * Method for starting the server.
	 * @throws Exception This is thrown when the FileSystem hasn't been initialized and set
	 */
	public static void start() throws Exception {
		if(server.getFileSystem() == null) {
			throw new Exception("FileSystem not set");
		}
		//start server
		EasyFTPServerFactory.server.start();
		
	}

	/**
	 * Stops the server
	 */
	public static void stop() {
		EasyFTPServerFactory.server.stop();
	}

	/**
	 * Sets the port that the FTP server binds to
	 * @param port Can provide 0 for a random port, or a specific port number
	 */
	public static void setPort(int port) {
		EasyFTPServerFactory.server.setServerControlPort(port);
	}

	/**
	 * Returns a list of files starting at root "/"
	 * @return List of files
	 */
	public static List<?> getFiles() {
		return EasyFTPServerFactory.getFiles("/");
	}

	/**
	 * Returns files from a provided path
	 * @param path Path to get files from
	 * @return List of files
	 */
	public static List<?> getFiles(String path) {
		return EasyFTPServerFactory.server.getFileSystem().listNames(path);
	}

	/**
	 * Sets the filesystem used by the FTP server
	 * @param filesystem FileSystem object
	 */
	public static void setFileSystem(EasyFTPFiles filesystem) {
		EasyFTPServerFactory.server.setFileSystem(filesystem.getFileSystem());
	}

	/**
	 * Sets the user accounts used by the FTP server
	 * @param userAccounts UserAccount object
	 */
	public static void setUserAccounts(EasyFTPUser userAccounts) {
		EasyFTPServerFactory.server.setUserAccounts(userAccounts.getUserAccounts());
	}

	
	
}