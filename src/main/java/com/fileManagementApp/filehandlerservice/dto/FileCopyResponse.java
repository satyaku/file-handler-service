package com.fileManagementApp.filehandlerservice.dto;

import java.nio.file.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@Scope(value = "prototype")
@ApiModel(description = "The response for the file copy operation.")
public class FileCopyResponse {
	
	@ApiModelProperty(notes = "Remarks about the activity status.")
	private String message;
	
	@ApiModelProperty(notes = "Location of the source file.")
	private Path src;
	
	@ApiModelProperty(notes = "Location of the destination file.")
	private Path dest;
	
	@ApiModelProperty(notes = "Download link of the source file.")
	private String srcUrl;
	
	@ApiModelProperty(notes = "Download link of the destination file.")
	private String destUrl;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Path getSrc() {
		return src;
	}
	public void setSrc(Path src) {
		this.src = src;
	}
	public Path getDest() {
		return dest;
	}
	public void setDest(Path dest) {
		this.dest = dest;
	}	
	public String getSrcUrl() {
		return srcUrl;
	}
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}
	public String getDestUrl() {
		return destUrl;
	}
	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}
	
	@Override
	public String toString() {
		return "FileCopyResponse [message=" + message + ", src=" + src + ", dest=" + dest + ", srcUrl=" + srcUrl
				+ ", destUrl=" + destUrl + "]";
	}	
}
