package com.college.management.system.serviceimp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.entity.StudentApplication;
import com.college.management.system.entity.FileImageData;
import com.college.management.system.repository.StudentApplicationRepository;
import com.college.management.system.repository.FileImageDataRepository;
import com.college.management.sytem.service.FileImageDataService;

@Service
public class FileIamgeDataServiceImp implements FileImageDataService{
	  	 
	
	@Autowired
	
	private FileImageDataRepository fileImageDataRepository;
	
	@Autowired
	private StudentApplicationRepository studentRepo;
	
	@Override
	public String uploadImageToFileService(MultipartFile file) {
		//logged user 
		String imageName=file.getOriginalFilename();
		String folderPath="D://image//";
		String fullPath=folderPath+imageName;
		
		try {
		Files.copy(file.getInputStream(), Paths.get(fullPath));
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		StudentApplication student = studentRepo.findByEmail("abcd").orElse(new StudentApplication());
		student.setPhoto(fullPath);
		studentRepo.save(student);
		return null;
	
	}	

}
