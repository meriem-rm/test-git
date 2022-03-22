package com.example.demo.api.upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {
    //  for apploading file we have to use MultipartFile and requestparam
	public static String saveFile(String filename, MultipartFile multiPartfile) throws IOException {
		// we specifie the path 
		Path uploadDirectory = Paths.get("files-Upload"); 
		// generate the characters we add before filename
		String fileCode = RandomStringUtils.randomAlphanumeric(8);
		
		   // with inputStream we add data to our destination file 
		try (InputStream inputStream = multiPartfile.getInputStream()) {
			// resolve -> convert a given string path to a path 
			Path filePath = uploadDirectory.resolve(fileCode + '-' + filename);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException ioe) {
			throw new IOException("error", ioe);
		}
		return fileCode;
	} 
	
	// method without adding generated code tot the filename
//	public class FileUploadUtils {
//	    //  for apploading file we have to use MultipartFile and requestparam
//		public static void saveFile(String filename, MultipartFile multiPartfile) throws IOException {
//			// we specifie the path 
//			Path uploadDirectory = Paths.get("files-Upload"); 
//			   // with inputStream we add data to our destination file 
//			try (InputStream inputStream = multiPartfile.getInputStream()) {
//				// resolve -> convert a given string path to a path 
//				Path filePath = uploadDirectory.resolve(filename);
//				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//			} catch(IOException ioe) {
//				throw new IOException("error", ioe);
//			}
//			
//		}
	
	
	
	
	
	
	
	
	
	
}
