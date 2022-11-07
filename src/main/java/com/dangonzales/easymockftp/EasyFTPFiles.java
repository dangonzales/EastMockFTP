package com.dangonzales.easymockftp;

import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;


public class EasyFTPFiles {
	private final FileSystem fs = new UnixFakeFileSystem();
	
	public EasyFTPFiles() {
	}
	
	public FileSystem getFileSystem() {
		return this.fs;
	}

	public void addFile(String path, String contents) {
		this.fs.add(new FileEntry(path, contents));
	}
	
	public void addFile(String[][] files_array) {
		for (String[] strings : files_array) {
			this.fs.add(new FileEntry(strings[0], strings[1]));
		}
	}
	
	public void addDirectory(String path) {
		String[] dirs = { path };
		this.addDirectory(dirs);
	}
	
	public void addDirectory(String[] paths) {
		for (String path : paths) {
			this.fs.add(new DirectoryEntry(path));
		}
	}
	
	public void removeEntry(String path) {
		this.fs.delete(path);
	}
	
	public void removeEntry(String[] paths) {
		for (String path : paths) {
			this.fs.delete(path);
		}
	}
	
}
