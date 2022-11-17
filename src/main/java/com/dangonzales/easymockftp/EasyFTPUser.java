package com.dangonzales.easymockftp;

import java.util.ArrayList;
import java.util.HashMap;

import org.mockftpserver.fake.UserAccount;

/**
 * Class for managing the FTP users
 */
public class EasyFTPUser {
	/**
	 * Hashmap of the usernames and passwords
	 */
	private final HashMap<String, UserAccount> accounts = new HashMap<>();

	/**
	 * Adds a user without a specified home dir. Default home dir is "/"
	 * @param username Username
	 * @param password Password
	 */
	public void addUser(String username, String password) {
		this.addUser(username, password, "/");
	}

	/**
	 * Adds a user with a specified home directory
	 * @param username Username
	 * @param password Password
	 * @param home_dir Home directory
	 */
	public void addUser(String username, String password, String home_dir) {
		this.accounts.put(username, new UserAccount(username, password, home_dir));
	}

	/**
	 * Adds an array of users.
	 * @param users 2D array of strings containing username, password, and an optional third parameter for home dir
	 */
	public void addUser(String[][] users)  {
		try {
			for (String[] user : users) {
				if (user.length == 3) {
					this.addUser(user[0], user[1], user[2]);
				} else {
					this.addUser(user[0], user[1]);
				}
			}
		} catch (Exception e) {
			System.out.println("Malformed user array. Users need at least a user name and password, with home dir optional");
			System.err.println(e.getMessage());
		}
		
	}

	/**
	 * Removes a user from the hashmap
	 * @param username Username
	 */
	public void removeUser(String username) {
		this.accounts.remove(username);
	}

	/**
	 * Returns a list of user accounts
	 * @return List of accounts
	 */
	public ArrayList<UserAccount> getUserAccounts(){
		return new ArrayList<>(this.accounts.values());
	}

}
