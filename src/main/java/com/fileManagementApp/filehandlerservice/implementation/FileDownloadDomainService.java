package com.fileManagementApp.filehandlerservice.implementation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.fileManagementApp.filehandlerservice.exceptions.InvalidResourceException;
import com.fileManagementApp.filehandlerservice.interfaces.IFileDownloadDomainService;

@Service
public class FileDownloadDomainService implements IFileDownloadDomainService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileDownloadDomainService.class);
	
	@Value("${file.upload.location}")
	private String fileHubLocation;

	@Override
	public Resource downLoadFile(String fileName) throws Exception {
		
		LOGGER.debug("Executing FileDownloadDomainService.");
		Path path = Paths.get(fileHubLocation)
				.toAbsolutePath()
				.resolve(fileName);
		Resource resource = new UrlResource(path.toUri());
		
		if(!resource.exists() || !resource.isReadable()){
			throw new InvalidResourceException("File '"+fileName+"'either doesn't exist or is not readable.");
		}
		
		LOGGER.debug("FileDownloadDomainService executed successfully.");
		return resource;
	}

}
