package com.fileManagementApp.filehandlerservice.implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fileManagementApp.filehandlerservice.interfaces.IFileUploadDomainService;

@Service
public class FileUploadDomainService implements IFileUploadDomainService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadDomainService.class);
	
	@Value("${file.upload.location}")
	private String fileUploadLocation;

	@Override
	public String uploadFile(MultipartFile file) throws IOException {
		
		LOGGER.debug("Executing FileUploadDomainService.");
		Path fileUploadPath = createFileUploadDirectory();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path filePath = Paths.get(fileUploadPath+"\\"+fileName);
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		LOGGER.debug("FileUploadDomainService executed successfully, filename : {}",fileName);
		return fileName;
	}

	private Path createFileUploadDirectory() throws IOException {
		Path fileUploadPath = Paths.get(fileUploadLocation).toAbsolutePath().normalize();
		Files.createDirectories(fileUploadPath);
		return fileUploadPath;
	}

}
