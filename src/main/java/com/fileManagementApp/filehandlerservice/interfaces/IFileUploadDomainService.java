package com.fileManagementApp.filehandlerservice.interfaces;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadDomainService {

	String uploadFile(MultipartFile file) throws IOException;

}
