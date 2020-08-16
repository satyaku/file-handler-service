package com.fileManagementApp.filehandlerservice.dto;

import java.nio.file.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@Scope(value = "prototype")
@ApiModel(description = "Response for the delete file operation.")
public class FileDeletionResponse {
	
	@ApiModelProperty(notes = "Name of the file deleted.")
	private String fileName;
	
	@ApiModelProperty(notes = "Location of the file deleted.")
	private Path path;
	
	@ApiModelProperty(notes = "Remarks for the delete file operation status.")
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
