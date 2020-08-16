package com.fileManagementApp.filehandlerservice.dto;

import java.nio.file.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class FileCopyResponse {
	
	private String message;
	private Path src;
	private Path dest;
	private String srcUrl;
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
