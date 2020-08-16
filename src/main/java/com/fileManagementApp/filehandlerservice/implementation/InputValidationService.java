package com.fileManagementApp.filehandlerservice.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileManagementApp.filehandlerservice.exceptions.InvalidInputException;
import com.fileManagementApp.filehandlerservice.interfaces.IInputValidationService;

@Service
public class InputValidationService implements IInputValidationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InputValidationService.class);

	@Override
	public void validate(MultipartFile file) throws Exception {
		
		LOGGER.debug("Executing InputValidationService.");
		if(file == null || file.isEmpty()){
			throw new InvalidInputException("Input file is empty or null.");
		}
		LOGGER.debug("InputValidationService executed successfully.");
	}

	@Override
	public void validate(String fileName) throws Exception {
		
		LOGGER.debug("Executing InputValidationService.");
		if(fileName == null || fileName.isEmpty()){
			throw new InvalidInputException("Input file name is empty or null.");
		}
		LOGGER.debug("InputValidationService executed successfully.");		
	}

	@Override
	public void validateForDeletion(String fileName) throws Exception {

		LOGGER.debug("Executing InputValidationService.");
		if(fileName == null || fileName.isEmpty()){
			throw new InvalidInputException("Input file name is empty or null.");
		}
		LOGGER.debug("InputValidationService executed successfully.");
	}

	@Override
	public void validateForCopy(String fileName) throws Exception {

		LOGGER.debug("Executing InputValidationService.");
		if(fileName == null || fileName.isEmpty()){
			throw new InvalidInputException("Input file name is empty or null.");
		}
		LOGGER.debug("InputValidationService executed successfully.");
	}

}
