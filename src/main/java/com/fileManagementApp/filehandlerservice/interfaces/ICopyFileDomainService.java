package com.fileManagementApp.filehandlerservice.interfaces;

import java.nio.file.Path;

public interface ICopyFileDomainService {

	Path[] copyFile(String fileName) throws Exception;

}
