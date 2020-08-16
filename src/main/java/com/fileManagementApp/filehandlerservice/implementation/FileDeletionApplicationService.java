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

import com.fileManagementApp.filehandlerservice.dto.FileDeletionResponse;
import com.fileManagementApp.filehandlerservice.interfaces.IFileDeletionApplicationService;
import com.fileManagementApp.filehandlerservice.interfaces.IFileDeletionDomainService;
import com.fileManagementApp.filehandlerservice.interfaces.IInputValidationService;

@Service
public class FileDeletionApplicationService implements IFileDeletionApplicationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileDeletionApplicationService.class);
	
	@Inject
	private IInputValidationService inputValidationService;
	
	@Inject
	private IFileDeletionDomainService fileDeletionDomainService;
	
	@Inject
	private Provider<FileDeletionResponse> provider;

	@Override
	public ResponseEntity<FileDeletionResponse> deleteFile(String fileName) {
		
		long start = System.currentTimeMillis();
		LOGGER.debug("Executing FileDeletionApplicationService.");
		Exception ex = null;
		Path path = null;
		try {
			inputValidationService.validateForDeletion(fileName);
			path = fileDeletionDomainService.deleteFile(fileName);			
		} catch (Exception e) {
			ex = e;
			e.printStackTrace();
		}
		
		ResponseEntity<FileDeletionResponse> response = prepareResponse(ex, path, fileName);
		LOGGER.info("FileDeletionApplicationService executed successfully in time : {}\n Response : {}", System.currentTimeMillis() - start, response);
		return response;
	}

	private ResponseEntity<FileDeletionResponse> prepareResponse(Exception ex, Path path, String fileName) {
		
		FileDeletionResponse response = provider.get();
		if(ex != null){
			if(ex instanceof NoSuchFileException){
				response.setMessage("No file with name "+fileName+" is found on the storage.");
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
			response.setMessage("File could not be deleted due to some error.");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.setFileName(fileName);
		response.setPath(path);
		response.setMessage("File deleted Successfully.");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
