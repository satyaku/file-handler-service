package com.fileManagementApp.filehandlerservice.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileManagementApp.filehandlerservice.dto.FileCopyResponse;
import com.fileManagementApp.filehandlerservice.dto.FileDeletionResponse;
import com.fileManagementApp.filehandlerservice.dto.FileUploadResponse;
import com.fileManagementApp.filehandlerservice.interfaces.IFileCopyApplicationService;
import com.fileManagementApp.filehandlerservice.interfaces.IFileDeletionApplicationService;
import com.fileManagementApp.filehandlerservice.interfaces.IFileUploadApplicationService;

@RestController
@RequestMapping("/fileManagement/v1")
public class FileWriterController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileWriterController.class);
	
	@Inject
	private IFileUploadApplicationService fileUploadApplicationService;
	
	@Inject
	private IFileDeletionApplicationService fileDeletionApplicationService;
	
	@Inject
	private IFileCopyApplicationService fileCopyApplicationService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public ResponseEntity<FileUploadResponse> upload(@RequestParam MultipartFile file){
		
		LOGGER.debug("Rest Endpoint '/fileManagement/v1/upload' is invoked.");
		return fileUploadApplicationService.uploadFile(file);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{fileName}")
	public ResponseEntity<FileDeletionResponse> deletePath(@PathVariable String fileName){
		
		LOGGER.debug("Rest Endpoint '/fileManagement/v1/delete/{}' is invoked.",fileName);
		return fileDeletionApplicationService.deleteFile(fileName);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/copy/{fileName}")
	public ResponseEntity<FileCopyResponse> copyFile(@PathVariable String fileName){
		
		LOGGER.debug("Rest Endpoint '/fileManagement/v1/copy/{}' is invoked.",fileName);

		return fileCopyApplicationService.copyFile(fileName);
	}

}
