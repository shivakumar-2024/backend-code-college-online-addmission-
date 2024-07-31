package com.college.management.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.sytem.service.FileImageDataService;

@RestController
public class FileImageDataController {

	@Autowired
	private FileImageDataService fileImageDataService;

	@PostMapping("/pic/user")
    public ResponseEntity<String> uploadImageToFile(@RequestParam("image") MultipartFile file) {
        String imo = fileImageDataService.uploadImageToFileService(file);
        return ResponseEntity.ok("uploaded");
    }
}
