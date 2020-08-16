package com.fileManagementApp.filehandlerservice.dto;

import java.nio.file.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class FileDeletionResponse {
	
	private String fileName;
	private Path path;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "FileDeletionResponse [fileName=" + fileName + ", path=" + path + ", message=" + message + "]";
	}
}
