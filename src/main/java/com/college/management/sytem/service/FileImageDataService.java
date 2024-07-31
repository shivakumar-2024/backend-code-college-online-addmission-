package com.college.management.sytem.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileImageDataService {

	String uploadImageToFileService(MultipartFile file);

}
