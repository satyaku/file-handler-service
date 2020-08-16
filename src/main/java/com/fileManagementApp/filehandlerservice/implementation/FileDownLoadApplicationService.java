package com.fileManagementApp.filehandlerservice.implementation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fileManagementApp.filehandlerservice.exceptions.InvalidResourceException;
import com.fileManagementApp.filehandlerservice.interfaces.IFileDownLoadApplicationService;
import com.fileManagementApp.filehandlerservice.interfaces.IFileDownloadDomainService;
import com.fileManagementApp.filehandlerservice.interfaces.IInputValidationService;

@Service
public class FileDownLoadApplicationService implements IFileDownLoadApplicationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileDownLoadApplicationService.class);
	
	@Inject
	private IInputValidationService inputValidationService;
	
	@Inject
	private IFileDownloadDomainService fileDownloadDomainService;

	@Override
	public ResponseEntity<Resource> downloadFile(String fileName, HttpServletRequest request) {
		
		long start = System.currentTimeMillis();
		LOGGER.debug("Executing FileDownLoadApplicationService");
		Exception ex = null;
		Resource resource = null;
		String mimeType = null;
		
		try {
			
			inputValidationService.validate(fileName);
			resource = fileDownloadDomainService.downLoadFile(fileName);
			
			try{
				mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			} catch (IOException e){
				mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
			}
			
		} catch (Exception e) {
			ex = e;
			e.printStackTrace();
		}
		if(ex != null){
			if(ex instanceof InvalidResourceException){
				return new ResponseEntity<>(resource,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(resource,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("FileDownLoadApplicationService successfully executed in time : {}",System.currentTimeMillis() - start);
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(mimeType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
				.body(resource);
	}

}
