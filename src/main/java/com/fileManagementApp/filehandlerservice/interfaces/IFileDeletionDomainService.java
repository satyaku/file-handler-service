package com.fileManagementApp.filehandlerservice.interfaces;

import java.io.IOException;
import java.nio.file.Path;

public interface IFileDeletionDomainService {

	Path deleteFile(String fileName) throws IOException;

}
