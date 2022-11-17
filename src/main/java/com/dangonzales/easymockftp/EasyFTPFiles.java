package com.dangonzales.easymockftp;

import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;


/**
 * Class for managing the FileSystem object
 */
public class EasyFTPFiles {
	private final FileSystem fs = new UnixFakeFileSystem();

	/**
	 * Getter for the FileSystem object
	 * @return FileSystem
	 */
	public FileSystem getFileSystem() {
		return this.fs;
	}

	/**
	 * Adds a single file.
	 * @param path The path of the file to add, including filename
	 * @param contents The contents of the file
	 */
	public void addFile(String path, String contents) {
		this.fs.add(new FileEntry(path, contents));
	}

	/**
	 * Adds an array of files
	 * @param files_array Array of arrays containing {path, contents}
	 */
	public void addFile(String[][] files_array) {
		for (String[] strings : files_array) {
			this.fs.add(new FileEntry(strings[0], strings[1]));
		}
	}

	/**
	 * Adds a directory
	 * @param path The path of the directory to add
	 */
	public void addDirectory(String path) {
		String[] dirs = { path };
		this.addDirectory(dirs);
	}

	/**
	 * Adds an array of directories
	 * @param paths Array containing paths
	 */
	public void addDirectory(String[] paths) {
		for (String path : paths) {
			this.fs.add(new DirectoryEntry(path));
		}
	}

	/**
	 * Deletes either a file or a directory
	 * @param path Path of the file or directory to be removed
	 */
	public void removeEntry(String path) {
		this.fs.delete(path);
	}

	/**
	 * Removes an array of directories or files
	 * @param paths Array of paths to be removed
	 */
	public void removeEntry(String[] paths) {
		for (String path : paths) {
			this.fs.delete(path);
		}
	}
	
}
