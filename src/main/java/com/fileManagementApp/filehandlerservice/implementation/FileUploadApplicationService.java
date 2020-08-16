package com.fileManagementApp.filehandlerservice.implementation;

import javax.inject.Inject;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileManagementApp.filehandlerservice.dto.FileUploadResponse;
import com.fileManagementApp.filehandlerservice.interfaces.IFileUploadApplicationService;
import com.fileManagementApp.filehandlerservice.interfaces.IFileUploadDomainService;
import com.fileManagementApp.filehandlerservice.interfaces.IInputValidationService;

@Service
public class FileUploadApplicationService implements IFileUploadApplicationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadApplicationService.class);
	
	@Inject
	private IInputValidationService inputValidationService;
	
	@Inject
	private IFileUploadDomainService fileUploadDomainService;
	
	@Inject
	private Provider<FileUploadResponse> provider;

	@Override
	public ResponseEntity<FileUploadResponse> uploadFile(MultipartFile file) {
		
		long start = System.currentTimeMillis();
		LOGGER.debug("Executing FileUploadApplicationService");
		FileUploadResponse response = provider.get();
		Exception ex = null;
		String fileName  = null;
		
		try {
			inputValidationService.validate(file);
			fileName = fileUploadDomainService.uploadFile(file);
		} catch (Exception e) {
			ex = e;
			e.printStackTrace();
		}
		if(ex != null){
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		prepeareResponse(response,file,fileName);
		LOGGER.info("FileUploadApplicationService successfully executed in time : {},\n Response : {}",System.currentTimeMillis() - start, response);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	private void prepeareResponse(FileUploadResponse response, MultipartFile file, String fileName) {
		response.setFileName(fileName);
		response.setContentType(file.getContentType());
		response.setUrl(ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/fileManagement/v1/download/")
				.path(fileName)
				.toUriString());
	}

}
