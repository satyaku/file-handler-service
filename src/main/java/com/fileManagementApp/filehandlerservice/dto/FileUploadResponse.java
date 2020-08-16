package com.fileManagementApp.filehandlerservice.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@Scope(value = "prototype")
@ApiModel(description = "Response for the file upload operation.")
public class FileUploadResponse {
	
	@ApiModelProperty(notes = "Name of the uploaded file.")
	private String fileName;
	
	@ApiModelProperty(notes = "Content type of the uploaded file.")
	private String contentType;
	
	@ApiModelProperty(notes = "Download link for the uploaded file.")
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
