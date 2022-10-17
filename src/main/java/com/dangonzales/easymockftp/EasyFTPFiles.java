package com.dangonzales.easymockftp;

import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.FileSystemEntry;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;


public class EasyFTPFiles {
	private FileSystem fs = new UnixFakeFileSystem();
	
	public EasyFTPFiles() {
	}
	
	public FileSystem getFileSystem() {
		return this.fs;
	}

	public void addFile(String path, String contents) {
		String files[][] = { {path, contents} };
		this.fs.add(new FileEntry(path, contents));
	}
	
	public void addFile(String[][] files_array) {
		for(int i = 0; i< files_array.length; i++) {
			this.fs.add(new FileEntry(files_array[i][0],files_array[i][1]));
		}
	}
	
	public void addDirectory(String path) {
		String dirs[] = { path };
		this.addDirectory(dirs);
	}
	
	public void addDirectory(String[] paths) {
		for(int i = 0; i< paths.length; i++) {
			this.fs.add(new DirectoryEntry(paths[i]));
		}
	}
	
	public void removeEntry(String path) {
		this.fs.delete(path);
	}
	
	public void removeEntry(String[] paths) {
		for(int i = 0; i< paths.length; i++) {
			this.fs.delete(paths[i]);
		}
	}
	
}
