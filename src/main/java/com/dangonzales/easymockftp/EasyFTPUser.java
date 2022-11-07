package com.dangonzales.easymockftp;

import java.util.ArrayList;
import java.util.HashMap;

import org.mockftpserver.fake.UserAccount;

public class EasyFTPUser {
	private final HashMap<String, UserAccount> accounts = new HashMap<>();
	public EasyFTPUser() {
	}
	
	public void addUser(String username, String password) {
		this.addUser(username, password, "/");
	}
	
	public void addUser(String username, String password, String home_dir) {
		this.accounts.put(username, new UserAccount(username, password, home_dir));
	}
	
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
	
	public void removeUser(String username) {
		this.accounts.remove(username);
	}
	
	public ArrayList<UserAccount> getUserAccounts(){
		return new ArrayList<>(this.accounts.values());
	}

}
