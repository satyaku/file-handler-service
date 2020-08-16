package com.fileManagementApp.filehandlerservice.implementation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fileManagementApp.filehandlerservice.interfaces.ICopyFileDomainService;

@Service
public class CopyFileDomainService implements ICopyFileDomainService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CopyFileDomainService.class);
	
	@Value("${file.upload.location}")
	private String fileHubLocation;
	
	@Override
	public Path[] copyFile(String fileName) throws Exception {
		
		LOGGER.debug("Executing CopyFileDomainService.");
		Path[] path = new Path[2];
		path[0] = Paths.get(fileHubLocation)
				.toAbsolutePath()
				.resolve(fileName);
		path[1] = Paths.get(fileHubLocation)
				.toAbsolutePath()
				.resolve("CopyOf"+fileName);
		Files.copy(path[0], path[1], StandardCopyOption.REPLACE_EXISTING);
		LOGGER.debug("CopyFileDomainService executed successfully with paths in response : src - {}, dest - {}", path[0], path[1]);
		return path;
	}

}
