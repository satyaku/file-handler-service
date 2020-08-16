package com.fileManagementApp.filehandlerservice.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fileManagementApp.filehandlerservice.dto.FileUploadResponse;

public interface IFileUploadApplicationService {

	ResponseEntity<FileUploadResponse> uploadFile(MultipartFile file);

}
