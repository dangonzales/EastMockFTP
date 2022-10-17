package com.dangonzales.easymockftp;

import java.util.ArrayList;
import java.util.HashMap;

import org.mockftpserver.fake.UserAccount;

public class EasyFTPUser {
	HashMap<String, UserAccount> accounts = new HashMap<>();
	public EasyFTPUser() {
	}
	
	public void addUser(String username, String password) {
		this.addUser(username, password, "/");
	}
	
	public void addUser(String username, String password, String home_dir) {
		this.accounts.put(username, new UserAccount(username, password, home_dir));
	}
	
	public void removeUser(String username) {
		this.accounts.remove(username);
	}
	
	public ArrayList<UserAccount> getUserAccounts(){
		return new ArrayList<UserAccount>(this.accounts.values());
	}

}
