package com.fileManagementApp.filehandlerservice.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IInputValidationService {

	void validate(MultipartFile file) throws Exception;

	void validate(String fileName) throws Exception;

	void validateForDeletion(String fileName) throws Exception;

	void validateForCopy(String fileName) throws Exception;

}
