package com.fileManagementApp.filehandlerservice.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class FileUploadResponse {
	
	private String fileName;
	private String contentType;
	private String url;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "FileUploadResponse [fileName=" + fileName + ", contentType=" + contentType + ", url=" + url + "]";
	}

}
