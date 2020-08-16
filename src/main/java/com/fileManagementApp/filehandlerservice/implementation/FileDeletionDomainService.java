package com.fileManagementApp.filehandlerservice.implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fileManagementApp.filehandlerservice.interfaces.IFileDeletionDomainService;

@Service
public class FileDeletionDomainService implements IFileDeletionDomainService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileDeletionDomainService.class);

	@Value("${file.upload.location}")
	private String fileHubLocation;

	@Override
	public Path deleteFile(String fileName) throws IOException {
		
		LOGGER.debug("Executing FileDeletionDomainService");
		Path path = Paths.get(fileHubLocation)
				.toAbsolutePath()
				.resolve(fileName);
		
		Files.delete(path);		
		
		LOGGER.debug("FileDeletionDomainService executed successfully. Path : {}",path);
		return path;
	}

}
