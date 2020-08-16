package com.fileManagementApp.filehandlerservice.implementation;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import javax.inject.Inject;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileManagementApp.filehandlerservice.dto.FileCopyResponse;
import com.fileManagementApp.filehandlerservice.interfaces.ICopyFileDomainService;
import com.fileManagementApp.filehandlerservice.interfaces.IFileCopyApplicationService;
import com.fileManagementApp.filehandlerservice.interfaces.IInputValidationService;

@Service
public class FileCopyApplicationService implements IFileCopyApplicationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileCopyApplicationService.class);
	
	@Inject
	private Provider<FileCopyResponse> provider;
	
	@Inject
	private IInputValidationService inputValidationService;
	
	@Inject
	private ICopyFileDomainService copyFileDomainService;

	@Override
	public ResponseEntity<FileCopyResponse> copyFile(String fileName) {
		
		long start = System.currentTimeMillis();
		LOGGER.debug("Executing FileCopyApplicationService.");
		Exception ex = null;
		Path[] path = null;
		try {
			inputValidationService.validateForCopy(fileName);
			path = copyFileDomainService.copyFile(fileName);
		} catch (Exception e) {
			ex = e;
			e.printStackTrace();
		}
		ResponseEntity<FileCopyResponse> response = prepareResponse(fileName, path, ex);
		LOGGER.info("FileCopyApplicationService executed successfully in time : {}\n Response : {}", System.currentTimeMillis() - start, response);
		return response;
	}

	private ResponseEntity<FileCopyResponse> prepareResponse(String fileName, Path[] path, Exception ex) {
		
		FileCopyResponse response = provider.get();
		
		if(ex != null){
			if(ex instanceof NoSuchFileException){
				response.setMessage("No file with name "+fileName+" is found on the storage.");
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			response.setMessage("File could not be copied due to some error.");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.setSrc(path[0]);
		response.setDest(path[1]);
		response.setMessage("File copied successfully.");
		response.setSrcUrl(ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/fileManagement/v1/download/")
				.path(fileName)
				.toUriString());
		response.setDestUrl(ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/fileManagement/v1/download/")
				.path("CopyOf"+fileName)
				.toUriString());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
