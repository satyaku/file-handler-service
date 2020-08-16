package com.fileManagementApp.filehandlerservice.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fileManagementApp.filehandlerservice.interfaces.IFileDownLoadApplicationService;

@RestController
@RequestMapping("/fileManagement/v1")
public class FileReaderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileWriterController.class);

	@Inject
	private IFileDownLoadApplicationService fileDownLoadApplicationService;

	@RequestMapping(method = RequestMethod.GET, value = "/download/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

		LOGGER.debug("Rest Endpoint '/fileManagement/v1/download/{}' is invoked.", fileName);
		return fileDownLoadApplicationService.downloadFile(fileName, request);
	}

}
