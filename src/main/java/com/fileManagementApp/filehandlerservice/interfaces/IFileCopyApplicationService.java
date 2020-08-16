package com.fileManagementApp.filehandlerservice.interfaces;

import org.springframework.http.ResponseEntity;

import com.fileManagementApp.filehandlerservice.dto.FileCopyResponse;

public interface IFileCopyApplicationService {

	ResponseEntity<FileCopyResponse> copyFile(String fileName);

}
