package com.example.demo.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.upload.FileUploadResponse;
import com.example.demo.api.upload.FileUploadUtils;

@RestController
public class FileController {

	@PostMapping("/uploadfile")  

	public ResponseEntity<FileUploadResponse> uploadfile(
			@RequestParam("file") MultipartFile multipartFile ) throws IOException {
		String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize(); 
		
		String fileCode = FileUploadUtils.saveFile(filename, multipartFile); 
		
		FileUploadResponse response = new FileUploadResponse();
		response.setFileName(filename);
		response.setSize(size);
		response.setDownloadUri("/downloadFile" + fileCode); 
		
		return new ResponseEntity<>(response, HttpStatus.OK );
	} 
	
//	public ResponseEntity<FileUploadResponse> uploadfile(
//			@RequestParam("file") MultipartFile multipartFile ) throws IOException {
//		String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		long size = multipartFile.getSize(); 
//		
//		FileUploadUtils.saveFile(filename, multipartFile); 
//		
//		FileUploadResponse response = new FileUploadResponse();
//		response.setFileName(filename);
//		response.setSize(size);
//		response.setDownloadUri("/downloadFile"); 
//		
//		return new ResponseEntity<>(response, HttpStatus.OK );
//	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
