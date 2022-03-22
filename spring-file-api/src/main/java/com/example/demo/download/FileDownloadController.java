package com.example.demo.download;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController { 
	
	@GetMapping("/downloadFile/{fileCode}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
		FileDownloadUtils filedownload = new FileDownloadUtils(); 
		Resource resource = null; 
		
		try {
			resource = filedownload.getFileasResource(fileCode);
		} catch(IOException ex) {
			return ResponseEntity.internalServerError().build();
		}
		if (resource == null ) {
			return new ResponseEntity<>("file not found", HttpStatus.NOT_FOUND);
		}
		String contentType ="application/octet-stream";
		String headerValue = "attachment; filename=\"" +  resource.getFilename() + "\"";
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
				.body(resource);
	}

}
