package com.fileManagementApp.filehandlerservice.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface IFileDownLoadApplicationService {

	ResponseEntity<Resource> downloadFile(String fileName, HttpServletRequest request);

}
