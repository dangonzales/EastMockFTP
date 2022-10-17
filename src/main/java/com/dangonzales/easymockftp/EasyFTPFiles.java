package com.dangonzales.easymockftp;

import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.FileSystemEntry;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;


public class EasyFTPFiles {
	private FileSystem fs = new UnixFakeFileSystem();
	//TODO clean this up, simple methods. Can still overload them
	public EasyFTPFiles() {
	}
	
	public FileSystem getFileSystem() {
		return this.fs;
	}

	public void addFile(String path, String contents) {
		String files[][] = { {path, contents} };
		this.addFile(files);
	}
	
	public void addFile(String[][] files_array) {
		FileEntry files[] = new FileEntry[files_array.length];
		for(int i = 0; i< files_array.length; i++) {
			files[i]= new FileEntry(files_array[i][0],files_array[i][1]);
		}
		this.addEntry(files);
	}
	
	public void addDirectory(String path) {
		String dirs[] = { path };
		this.addDirectory(dirs);
	}
	
	public void addDirectory(String[] paths) {
		DirectoryEntry dirs[] = new DirectoryEntry[paths.length];
		for(int i = 0; i< paths.length; i++) {
			dirs[i]= new DirectoryEntry(paths[i]);
		}
		this.addEntry(dirs);
	}
	
	private void addEntry(FileSystemEntry[] entries) {
		for(int i = 0; i< entries.length; i++) {
			this.fs.add(entries[i]);
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
