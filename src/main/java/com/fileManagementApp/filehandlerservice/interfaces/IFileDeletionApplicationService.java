package com.fileManagementApp.filehandlerservice.interfaces;

import org.springframework.http.ResponseEntity;

import com.fileManagementApp.filehandlerservice.dto.FileDeletionResponse;

public interface IFileDeletionApplicationService {

	ResponseEntity<FileDeletionResponse> deleteFile(String fileName);

}
