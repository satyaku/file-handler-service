package com.fileManagementApp.filehandlerservice.interfaces;

import org.springframework.core.io.Resource;

public interface IFileDownloadDomainService {

	Resource downLoadFile(String fileName) throws Exception;

}
